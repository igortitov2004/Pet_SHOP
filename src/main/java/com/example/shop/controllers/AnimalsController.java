package com.example.shop.controllers;
import com.example.shop.models.AnimalsModel;
import com.example.shop.services.AnimalsService;
import com.example.shop.services.BreedsService;
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
public class AnimalsController {
    private final AnimalsService animalsService;
    private final BreedsService breedsService;
    private final StaffController staffController;
    @GetMapping("/animals")
    public String animals(@RequestParam(name = "kindOfAnimal", required = false) String kindOfAnimal, Model model){
        model.addAttribute("animals", animalsService.listAnimals(kindOfAnimal));
        model.addAttribute("breeds", breedsService.listBreeds());
        model.addAttribute("user", staffController.user);
        return "animals";
    }
    @PostMapping("/animals/create")
    public String createAnimal(AnimalsModel animals){
        animalsService.saveAnimal(animals);
        return "redirect:/animals";
    }
    @PostMapping("/animals/delete/{id_animals}")
    public String deleteAnimal(@PathVariable Long id_animals){
        animalsService.deleteAnimal(id_animals);
        return "redirect:/animals";
    }
}
