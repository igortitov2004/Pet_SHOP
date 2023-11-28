package com.example.shop.controllers;


import com.example.shop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_DIRECTOR','ROLE_MANAGER','ROLE_CASHIER')")
public class MainController {
    private final UserService userService;
    @GetMapping("/")
    public String mainPage(Principal principal, Model model){
        model.addAttribute("user",userService.getUserByPrincipal(principal));
        return "main-page";
    }
}
