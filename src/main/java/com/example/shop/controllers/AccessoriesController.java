package com.example.shop.controllers;

import com.example.shop.models.AccessoriesModel;

import com.example.shop.repositories.AccessoriesRepository;
import com.example.shop.services.AccessoriesService;
import com.example.shop.services.AnimalsService;
import com.example.shop.util.AccessorValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_DIRECTOR','ROLE_MANAGER','ROLE_CASHIER')")
public class AccessoriesController {

    private final AccessoriesService accessoriesService;
    private final AnimalsService animalsService;
    private final AccessoriesRepository accessoriesRepository;
    private final StaffController staffController;

    private final AccessorValidator accessorValidator;
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

    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
    @GetMapping("/accessories/create")
    public String startCreateAccessor(@ModelAttribute("newAccessor") AccessoriesModel accessor,Model model){
        model.addAttribute("animals",animalsService.listAnimals(null));
        accessor.setPriceOfAccessor(0);
        accessor.setNameOfAccessor("");
        accessor.setManufacturerOfAccessor("");
        return "accessor-creation";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
    @PostMapping("/accessories/create")
    public String createAccessor(@Valid @ModelAttribute("newAccessor") AccessoriesModel accessor, BindingResult bindingResult,Model model){
        accessorValidator.validate(accessor,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("animals",animalsService.listAnimals(null));
            model.addAttribute("accessorErr",bindingResult.hasErrors());
            return "accessor-creation";
        }
        accessoriesService.saveAccessor(accessor);
        return "redirect:/accessories";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER','ROLE_CASHIER')")
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
    public String editAccessor(@PathVariable(value = "id_accessories") Long id_accessories,@Valid @ModelAttribute("accessories") AccessoriesModel accessor,
                               BindingResult bindingResult, Model model){
        AccessoriesModel modifiedAccessor=accessoriesService.getAccessorById(id_accessories);
        modifiedAccessor.setPriceOfAccessor(accessor.getPriceOfAccessor());
        accessorValidator.validate(modifiedAccessor,bindingResult);
        if(bindingResult.hasErrors()){
            // SO BAD
            accessor.setNameOfAccessor(modifiedAccessor.getNameOfAccessor());
            accessor.setManufacturerOfAccessor(modifiedAccessor.getManufacturerOfAccessor());
            accessor.setPriceOfAccessor(modifiedAccessor.getPriceOfAccessor());
            accessor.setAnimal(modifiedAccessor.getAnimal());
            model.addAttribute("editAccessorErr","Такой аксессуар с этой стоимостью уже существует!");
            return "edit-accessor";
        }
        accessoriesRepository.save(modifiedAccessor);
        return "redirect:/accessories";
    }
}
