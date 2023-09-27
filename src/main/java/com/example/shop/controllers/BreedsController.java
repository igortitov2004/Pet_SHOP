package com.example.shop.controllers;

import com.example.shop.models.AnimalsModel;
import com.example.shop.models.BreedsModel;
import com.example.shop.services.BreedsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_DIRECTOR','ROLE_MANAGER','ROLE_CASHIER')")
public class BreedsController {
    private final BreedsService breedsService;

    @PostMapping("/breed/create")
    public String createBreed(BreedsModel breed){
        breedsService.saveBreed(breed);
        return "redirect:/animals";

    }
}
