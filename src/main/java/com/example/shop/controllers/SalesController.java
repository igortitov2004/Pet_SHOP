package com.example.shop.controllers;

import com.example.shop.models.SalesModel;

import com.example.shop.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

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

    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER','ROLE_CASHIER')")
    @PostMapping("/sales/startCreation")
    public String startSaleCreation(Model model){
        sale=new SalesModel();
        sale.setStaff_id_for_sale(null);
        sale.setDateOfSale("");
        sale.setSold_feedsModelList(new ArrayList<>());
        sale.setSold_accessoriesModelList(new ArrayList<>());
        model.addAttribute("sale", sale);
        model.addAttribute("feed", feedsService.listFeeds(null).stream().filter(o->o.getAmountOfFeeds()>0).collect(Collectors.toList()));
        model.addAttribute("accessor", accessoriesService.listAccessories(null).stream().filter(o->o.getAmount_of_accessories()>0).collect(Collectors.toList()));
//        model.addAttribute("staffs", staffService.listStaffs(null));
        return "sale-creation";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER','ROLE_CASHIER')")
    @GetMapping("/sales/create")
    public String saleCreation(Model model){
        model.addAttribute("sale", sale);
        model.addAttribute("feed", feedsService.listFeeds(null).stream().filter(o->o.getAmountOfFeeds()>0).collect(Collectors.toList()));
        model.addAttribute("accessor", accessoriesService.listAccessories(null).stream().filter(o->o.getAmount_of_accessories()>0).collect(Collectors.toList()));
        return "sale-creation";
    }
    @PostMapping("/sales/addFeed")
    public String addFeedInSale(Long id_feeds, int amount,Model model){
        int availableAmount = feedsService.getAmountOfSold(sale,id_feeds);
        if(amount>availableAmount){
            model.addAttribute("sale", sale);
            model.addAttribute("feed", feedsService.listFeeds(null));
            model.addAttribute("accessor", accessoriesService.listAccessories(null));
            model.addAttribute("amount",availableAmount);
            model.addAttribute("errFeed",true);
            return "sale-creation";
        }
        sale=salesService.addingFeedsInSale(sale,id_feeds,amount);
        return "redirect:/sales/create";
    }
    @PostMapping("/sales/addAccessor")
    public String addAccessorInSale(Long id_accessories, int amount, Model model){
        int availableAmount = accessoriesService.getAmountOfSold(sale,id_accessories);
        if(amount> availableAmount){
            model.addAttribute("sale", sale);
            model.addAttribute("feed", feedsService.listFeeds(null));
            model.addAttribute("accessor", accessoriesService.listAccessories(null));
            model.addAttribute("amount",availableAmount);
            model.addAttribute("errAccessor",true);
            return "sale-creation";
        }
        sale=salesService.addingAccessoriesInSale(sale,id_accessories,amount);
        //sale=salesService.addingNewAccessorInSale(sale, accessoriesService.getAccessorById(id_accessories),amount);
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
