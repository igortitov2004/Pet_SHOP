package com.example.shop.services;

import com.example.shop.models.StaffModel;
import com.example.shop.models.User;
import com.example.shop.models.enums.Role;
import com.example.shop.repositories.StaffRepository;
import com.example.shop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final StaffRepository staffRepository;
    private final PasswordEncoder passwordEncoder;
    public boolean createUser(User user){
        if(userRepository.findUserByLogin(user.getLogin())!=null || staffRepository.findStaffModelByTelNumber(user.getTelNumber())==null
        || userRepository.findUserByTelNumber(user.getTelNumber())!=null){
            return false;
        }
        StaffModel staff=staffRepository.findStaffModelByTelNumber(user.getTelNumber());
        user.setStaff(staff);
        user=setUserRole(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }


    public boolean isLogin(User user){
        if(userRepository.findUserByLogin(user.getUsername())!=null){
            return true;
        }
        return false;
    }
    public User setUserRole(User user){
        switch (user.getStaff().getJob_title()){
            case "Директор": user.setId_role(Role.ROLE_DIRECTOR); break;
            case "Менеджер": user.setId_role(Role.ROLE_MANAGER); break;
            case "Продавец-кассир": user.setId_role(Role.ROLE_CASHIER); break;
        }
        return user;
    }

    public boolean doPasswordsMatch(String firstPassword,String secondPassword){
        return passwordEncoder.matches(firstPassword,secondPassword);
    }
    public String doPasswordEncode(String password){
        return passwordEncoder.encode(password);
    }


    public User getUserByPrincipal(Principal principal){
        if(principal==null) return new User();
        return userRepository.findUserByLogin(principal.getName());
    }
}
