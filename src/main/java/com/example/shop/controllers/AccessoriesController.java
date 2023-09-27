package com.example.shop.controllers;

import com.example.shop.models.AccessoriesModel;

import com.example.shop.models.FeedsModel;
import com.example.shop.repositories.AccessoriesRepository;
import com.example.shop.services.AccessoriesService;
import com.example.shop.services.AnimalsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_DIRECTOR','ROLE_MANAGER','ROLE_CASHIER')")
public class AccessoriesController {

    private final AccessoriesService accessoriesService;
    private final AnimalsService animalsService;
    private final AccessoriesRepository accessoriesRepository;
    private final StaffController staffController;
    @GetMapping("/accessories")
    public String accessories(@RequestParam(name = "nameOfAccessor", required = false) String nameOfAccessor, Model model){
        model.addAttribute("accessories",accessoriesService.listAccessories(nameOfAccessor));
        model.addAttribute("animals",animalsService.listAnimals(null));
        model.addAttribute("user", staffController.user);
        return "accessories";
    }
    @GetMapping("/accessories/{id_accessories}")
    public String accesorInfo(@PathVariable Long id_accessories, Model model){
        model.addAttribute("accessor", accessoriesService.getAccessorById(id_accessories));
        return "accessor-info";
    }
    @PostMapping("/accessories/create")
    public String createAccessor(AccessoriesModel accessor){
        accessoriesService.saveAccessor(accessor);
        return "redirect:/accessories";

    }
    @PostMapping("/accessories/delete/{id_accessories}")
    public String deleteAccessor(@PathVariable Long id_accessories){
        accessoriesService.deleteAccessor(id_accessories);
        return "redirect:/accessories";

    }

    @GetMapping("/accessories/{id_accessories}/edit")
    public String startEditAccessor(@PathVariable(value = "id_accessories") Long id_accessories ,Model model){
        model.addAttribute("accessories",accessoriesService.getAccessorById(id_accessories));
        return "edit-accessor";
    }
    @PostMapping("/accessories/{id_accessories}/edit")
    public String editFeed(@PathVariable(value = "id_accessories") Long id_accessories , AccessoriesModel accessoriesModel){
        AccessoriesModel accessor=accessoriesService.getAccessorById(id_accessories) ;
        accessor.setPrice_of_accessor(accessoriesModel.getPrice_of_accessor());
       accessoriesRepository.save(accessor);
        return "redirect:/accessories";
    }
}
