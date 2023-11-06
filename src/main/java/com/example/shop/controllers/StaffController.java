package com.example.shop.controllers;

import com.example.shop.models.StaffModel;
import com.example.shop.models.User;
import com.example.shop.services.SalesService;
import com.example.shop.services.StaffService;
import com.example.shop.services.UserService;
import com.example.shop.util.StaffValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_DIRECTOR','ROLE_MANAGER','ROLE_CASHIER')")
public class StaffController {
    private final StaffService staffService;
    private final SalesService salesService;
    private final UserService userService;

    private final StaffValidator staffValidator;


    public User user;
    @GetMapping("/staff")
    public String staff(@RequestParam (name = "fullName", required = false) String fullName, Model model){
        model.addAttribute("staffs",staffService.listStaffs(fullName));
        model.addAttribute("sales",salesService.listSales(null));
        model.addAttribute("user", user);
        return "staff";
    }
    @GetMapping("/staff/{id_staff}/edit")
    public String startEditStaff(@PathVariable(value = "id_staff") Long id_staff ,Model model){
        model.addAttribute("staff",staffService.getStaffById(id_staff));
        return "edit-staff";
    }
    @PostMapping("/staff/{id_staff}/edit")
    public String editStaff(@PathVariable(value = "id_staff") Long id_staff , @Valid @ModelAttribute("staff") StaffModel staff,BindingResult bindingResult,Model model){
        staffValidator.validate(staff,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("err",bindingResult.hasErrors());
            return "edit-staff";
        }
        staffService.update(id_staff,staff);
        return "redirect:/staff";
    }

    @GetMapping("/")
    public String mainPage(Principal principal,Model model){
        model.addAttribute("user",userService.getUserByPrincipal(principal));
        return "main-page";
    }
    @GetMapping("/staff/{id_staff}")
    public String staffInfo(@PathVariable Long id_staff,Principal  principal, Model model){
        model.addAttribute("staff", staffService.getStaffById(id_staff));
        model.addAttribute("user",userService.getUserByPrincipal(principal));
        return "staff-info";
    }

    @GetMapping("/staff/create")
    public String startCreateStaff(@ModelAttribute("staff") StaffModel staff, Model model){
        staff.setFullName("");
        staff.setNumOfPassport("");
        staff.setTelNumber("+375");
        staff.setExperience(0);
        staff.setJob_title("");
        return "staff-creation";
    }
    @PostMapping("/staff/create")
    public String createStaff(@Valid @ModelAttribute("staff")  StaffModel staff, BindingResult bindingResult,Model model){
        staffValidator.validate(staff,bindingResult);
       if(bindingResult.hasErrors()){
           model.addAttribute("err",bindingResult.hasErrors());
           return "staff-creation";
       }
       if(!staffService.isStaff(staff)){
           model.addAttribute("errorMessage","Работник с номером "+staff.getTelNumber()+" уже существует!!!");
           return "staff-creation";
       }
        staffService.saveStaff(staff);
        return "redirect:/staff";
    }

    @PostMapping("/staff/delete/{id_staff}")
    public String deleteStaff(@PathVariable Long id_staff){
        staffService.deleteStaff(id_staff);
        return "redirect:/staff";
    }
}
