package com.example.shop.controllers;

import com.example.shop.models.AnimalsModel;
import com.example.shop.models.BreedsModel;
import com.example.shop.services.BreedsService;
import com.example.shop.util.BreedValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_DIRECTOR','ROLE_MANAGER','ROLE_CASHIER')")
public class BreedsController {
    private final BreedsService breedsService;
    private final BreedValidator breedValidator;
    @GetMapping("/breed/create")
    public String startCreateBreed(@ModelAttribute("newBreed") BreedsModel breed){
        breed.setBreed("");
        return "breed-creation";
    }
    @PostMapping("/breed/create")
    public String createBreed(@Valid @ModelAttribute("newBreed") BreedsModel breed, BindingResult bindingResult, Model model){
        breedValidator.validate(breed,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("breedErr",bindingResult.hasErrors());
            return "breed-creation";
        }
        breedsService.saveBreed(breed);
        return "redirect:/animals";
    }
}
