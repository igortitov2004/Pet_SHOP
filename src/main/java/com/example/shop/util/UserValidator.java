package com.example.shop.util;

import com.example.shop.models.User;
import com.example.shop.repositories.StaffRepository;
import com.example.shop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

    private final StaffRepository staffRepository;
    private final UserRepository userRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if(userRepository.findUserByLogin(user.getLogin())!=null){
            errors.rejectValue("login","","Человек с таким логином уже существует");
        }
        if(staffRepository.findStaffModelByTelNumber(user.getTelNumber())==null){
            errors.rejectValue("telNumber","","Для данного номера телефона отсутствует доступ к системе");
        }
        if(userRepository.findUserByTelNumber(user.getTelNumber())!=null){
            errors.rejectValue("telNumber","","Человек с таким номером телефона уже существует");
        }
    }
}
