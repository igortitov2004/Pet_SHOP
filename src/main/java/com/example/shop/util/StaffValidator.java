package com.example.shop.util;

import com.example.shop.models.StaffModel;
import com.example.shop.repositories.StaffRepository;
import com.example.shop.services.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class StaffValidator implements Validator {

    private final StaffService staffService;
    @Override
    public boolean supports(Class<?> clazz) {
        return StaffModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        StaffModel staff = (StaffModel) target;
        if(staffService.getStaffByNumOfPassport(staff.getNumOfPassport()).isPresent()){
            errors.rejectValue("numOfPassport","","Человек с таким паспортом уже существует");
        }
        if(staffService.getStaffByTelNumber(staff.getTelNumber()).isPresent()){
            errors.rejectValue("telNumber","","Человек с таким номером телефона уже существует");
        }
    }
}
