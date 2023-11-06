package com.example.shop.controllers;
import com.example.shop.models.AnimalsModel;
import com.example.shop.services.AnimalsService;
import com.example.shop.services.BreedsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
//        model.addAttribute("breeds", breedsService.listBreeds());
        model.addAttribute("user", staffController.user);
        return "animals";
    }

    @GetMapping("/animals/create")
    public String startCreateAnimal(@ModelAttribute("newAnimal") AnimalsModel animal, Model model){
        model.addAttribute("breeds", breedsService.listBreeds());
        animal.setKindOfAnimal("");
        animal.setAge_of_animal(0);
        animal.setWeight_of_animal(0);
        return "animal-creation";
    }
    @PostMapping("/animals/create")
    public String createAnimal(@Valid @ModelAttribute("newAnimal") AnimalsModel animal, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("breeds", breedsService.listBreeds());
            model.addAttribute("animalErr",bindingResult.hasErrors());
            return "animal-creation";
        }

        animalsService.saveAnimal(animal);
        return "redirect:/animals";
    }
    @PostMapping("/animals/delete/{id_animals}")
    public String deleteAnimal(@PathVariable Long id_animals){
        animalsService.deleteAnimal(id_animals);
        return "redirect:/animals";
    }
}
