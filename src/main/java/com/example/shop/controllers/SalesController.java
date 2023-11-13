package com.example.shop.controllers;

import com.example.shop.models.FeedsModel;
import com.example.shop.models.SalesModel;

import com.example.shop.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_DIRECTOR','ROLE_MANAGER','ROLE_CASHIER')")
public class SalesController {
    private final SalesService salesService;
    private final StaffService staffService;

   private final FeedsService feedsService;
   private final AccessoriesService accessoriesService;

   private final UserService userService;

   private final StaffController staffController;

   SalesModel sale;
    @GetMapping("/sales")
    public String sales(@RequestParam(name = "dateOfSale", required = false) String dateOfSale, Model model){
        model.addAttribute("sales", salesService.listSales(dateOfSale));
        model.addAttribute("staffs", staffService.listStaffs(null));
        model.addAttribute("user", staffController.user);
        return "sales";
    }

    @GetMapping("/sold_things/{id_sales}")
    public String sold_things( @PathVariable Long id_sales,Model model){
        model.addAttribute("sales", salesService.getSalesById(id_sales));
        return "sales-info";
    }
    @PostMapping("/sales/startCreation")
    public String startSaleCreation(Model model){
        sale=new SalesModel();
        sale.setStaff_id_for_sale(null);
        sale.setDateOfSale("");
        sale.setSold_feedsModelList(new ArrayList<>());
        sale.setSold_accessoriesModelList(new ArrayList<>());
        model.addAttribute("sale", sale);
        model.addAttribute("feed", salesService.getListOfAvailableFeeds(sale,feedsService.listFeeds(null)));
        model.addAttribute("accessor", salesService.getListOfAvailableAccessories(sale,accessoriesService.listAccessories(null)));
//        model.addAttribute("staffs", staffService.listStaffs(null));
        return "sale-creation";
    }
    @GetMapping("/sales/create")
    public String saleCreation(Model model){
        model.addAttribute("sale", sale);
        model.addAttribute("feed", salesService.getListOfAvailableFeeds(sale,feedsService.listFeeds(null)));
        model.addAttribute("accessor", salesService.getListOfAvailableAccessories(sale,accessoriesService.listAccessories(null)));
//        model.addAttribute("staffs", staffService.listStaffs(null));
        return "sale-creation";
    }
    @PostMapping("/sales/addFeed")
    public String addFeedInSale(Long id_feeds, int amount,Model model){
        if(amount>feedsService.getFeedById(id_feeds).getAmountOfFeeds()){
            model.addAttribute("sale", sale);
            model.addAttribute("feed", salesService.getListOfAvailableFeeds(sale,feedsService.listFeeds(null)));
            model.addAttribute("accessor", salesService.getListOfAvailableAccessories(sale,accessoriesService.listAccessories(null)));
            model.addAttribute("amount",feedsService.getFeedById(id_feeds).getAmountOfFeeds());
            model.addAttribute("errFeed",true);
            return "sale-creation";
        }
        sale=salesService.addFeedInSale(sale, feedsService.getFeedById(id_feeds),amount);
        return "redirect:/sales/create";
    }
    @PostMapping("/sales/addAccessor")
    public String addAccessorInSale(Long id_accessories, int amount, Model model){
        if(amount> accessoriesService.getAccessorById(id_accessories).getAmount_of_accessories()){
            model.addAttribute("sale", sale);
            model.addAttribute("feed", salesService.getListOfAvailableFeeds(sale,feedsService.listFeeds(null)));
            model.addAttribute("accessor", salesService.getListOfAvailableAccessories(sale,accessoriesService.listAccessories(null)));
            model.addAttribute("amount",accessoriesService.getAccessorById(id_accessories).getAmount_of_accessories());
            model.addAttribute("errAccessor",true);
            return "sale-creation";
        }
        sale=salesService.addAccessorInSale(sale, accessoriesService.getAccessorById(id_accessories),amount);
        return "redirect:/sales/create";
    }
    @PostMapping("/sales/save")
    public String saveSale(){
        sale.setStaff_id_for_sale(staffController.user.getStaff());
        salesService.saveSale(sale);
        return "redirect:/sales";
    }
    @GetMapping("/sales/deletePosFeed/{index}")
    public String deleteSoldFeed(@PathVariable int index){
        sale=salesService.deleteSoldFeed(index,sale);
        return "redirect:/sales/create";
    }
    @GetMapping("/sales/deletePosAccessor/{index}")
    public String deleteSoldAccessor(@PathVariable int index){
        sale=salesService.deleteSoldAccessor(index,sale);
        return "redirect:/sales/create";
    }
}
