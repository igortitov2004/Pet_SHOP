package com.example.shop.controllers;

import com.example.shop.models.User;
import com.example.shop.services.UserService;
import com.example.shop.util.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }
    @GetMapping("/loginError")
    public String checkLogin(){
        return "login/loginError";
    }
    @GetMapping("/registration")
    public String registration(){ return "registration"; }


    @PostMapping("/registration")
    public String createUser(User user, BindingResult bindingResult, Model model) {
        userValidator.validate(user,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("errorReg",bindingResult.hasErrors());
            return "registration";
        }
        userService.createUser(user);
//        if(!userService.createUser(user))
//        {
//            model.addAttribute("errorMessage","Ошибка регистрации пользователя с логином: "+user.getLogin());
//            return "registration";
//        }
        return "redirect:/login";
    }
}
