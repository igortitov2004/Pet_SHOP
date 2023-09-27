package com.example.shop.controllers;

import com.example.shop.models.SalesModel;
import com.example.shop.models.StaffModel;
import com.example.shop.models.User;
import com.example.shop.repositories.StaffRepository;
import com.example.shop.services.SalesService;
import com.example.shop.services.StaffService;
import com.example.shop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_DIRECTOR','ROLE_MANAGER','ROLE_CASHIER')")
public class StaffController {
    private final StaffService staffService;
    private final SalesService salesService;
    private final StaffRepository staffRepository;
    private final UserService userService;


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
    public String editStaff(@PathVariable(value = "id_staff") Long id_staff ,StaffModel staffModel){
        StaffModel staff= staffService.getStaffById(id_staff);
        staff.setFullName(staffModel.getFullName());
        staff.setNum_of_passport(staffModel.getNum_of_passport());
        staff.setTelNumber(staffModel.getTelNumber());
        staff.setExperience(staffModel.getExperience());
        staff.setJob_title(staffModel.getJob_title());
        staffRepository.save(staff);
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
    @PostMapping("/staff/create")
    public String createStaff(StaffModel staff, Model model){
       if(!staffService.isStaff(staff)){
           model.addAttribute("staffs",staffService.listStaffs(null));
           model.addAttribute("sales",salesService.listSales(null));
           model.addAttribute("user", user);
           model.addAttribute("errorMessage","Работник с номером "+staff.getTelNumber()+" уже существует!!!");
           return "staff";
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
