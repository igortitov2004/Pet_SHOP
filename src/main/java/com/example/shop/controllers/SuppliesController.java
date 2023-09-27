package com.example.shop.controllers;

import com.example.shop.models.FeedsModel;
import com.example.shop.models.SalesModel;
import com.example.shop.models.SuppliesModel;
import com.example.shop.services.AccessoriesService;
import com.example.shop.services.FeedsService;
import com.example.shop.services.StaffService;
import com.example.shop.services.SuppliesService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_DIRECTOR','ROLE_MANAGER','ROLE_CASHIER')")
public class SuppliesController {
    private final SuppliesService suppliesService;
    private final StaffService staffsService;

    private final FeedsService feedsService;
    private final AccessoriesService accessoriesService;
    private final StaffController staffController;

    SuppliesModel supply;
//    FeedsModel feed;

    @GetMapping("/supplies")
    public String supplies(@RequestParam(name = "dateOfSuppl", required = false) String dateOfSuppl, Model model){
        model.addAttribute("supplies", suppliesService.listSupplies(dateOfSuppl));
        model.addAttribute("staffs", staffsService.listStaffs(null));
        model.addAttribute("user", staffController.user);
        return "supplies";
    }

    @GetMapping("/supplied_things/{id_supplies}")
    public String supplied_things( @PathVariable Long id_supplies,Model model){
        model.addAttribute("supplies", suppliesService.getSupplyById(id_supplies));
        return "supplies-info";
    }


    @PostMapping("/supplies/startCreation")
    public String startSupplyCreation(Model model){
        supply=new SuppliesModel();
        supply.setStaff_id_for_suppl(null);
        supply.setDateOfSuppl("");
        supply.setSupplied_feedsModelList(new ArrayList<>());
        supply.setSupplied_accessoriesModelList(new ArrayList<>());
        model.addAttribute("supply", supply);
        model.addAttribute("feed", feedsService.listFeeds(null));
//        model.addAttribute("feedss", feed);
        model.addAttribute("accessor", accessoriesService.listAccessories(null));
//        model.addAttribute("staffs", staffsService.listStaffs(null));
        return "supply-creation";
    }

//    @PostMapping("/supplies/startCreationAmount/{id_feeds}")
//    public void startSupplyCreation(@PathVariable Long id_feeds,Model model){
//
//        model.addAttribute("feedss", feedsService.getFeedById(id_feeds));
//
//    }


    @GetMapping("/supplies/create")
    public String supplyCreation(Model model){

        model.addAttribute("supply", supply);
        model.addAttribute("feed", feedsService.listFeeds(null));
        model.addAttribute("accessor", accessoriesService.listAccessories(null));
//        model.addAttribute("staffs", staffsService.listStaffs(null));
        return "supply-creation";
    }

    @PostMapping("/supplies/addFeed")
    public String addFeedInSupply(Long id_feeds, int amount){
        supply=suppliesService.addFeedInSupply(supply, feedsService.getFeedById(id_feeds),amount);
        return "redirect:/supplies/create";
    }

    @PostMapping("/supplies/addAccessor")
    public String addAccessorInSale(Long id_accessories, int amount){
        supply=suppliesService.addAccessorInSupply(supply, accessoriesService.getAccessorById(id_accessories),amount);
        return "redirect:/supplies/create";
    }
    @PostMapping("/supplies/save")
    public String saveSupply(){

        supply.setStaff_id_for_suppl(staffController.user.getStaff());
        suppliesService.saveSupply(supply);
        return "redirect:/supplies";
    }

    @GetMapping("/supplies/deletePosFeed/{index}")
    public String deleteSuppliedFeed(@PathVariable int index){
        supply=suppliesService.deleteSuppliedFeed(index,supply);
        return "redirect:/supplies/create";

    }

    @GetMapping("/supplies/deletePosAccessor/{index}")
    public String deleteSuppliedAccessor(@PathVariable int index){
        supply=suppliesService.deleteSuppliedAccessor(index,supply);
        return "redirect:/supplies/create";

    }





    @PostMapping("/supplies/delete/{id_supplies}")
    public String deleteSupply(@PathVariable Long id_supplies){
        suppliesService.deleteSupply(id_supplies);
        return "redirect:/sales";

    }
}
