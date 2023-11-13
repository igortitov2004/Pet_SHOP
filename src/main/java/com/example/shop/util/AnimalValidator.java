package com.example.shop.util;

import com.example.shop.models.AnimalsModel;
import com.example.shop.repositories.AnimalsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
@RequiredArgsConstructor
public class AnimalValidator implements Validator {
    private final AnimalsRepository animalsRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return AnimalsModel.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
         AnimalsModel animal = (AnimalsModel) target;
         if(animalsRepository.findAnimalsModelByKindOfAnimalAndAgeOfAnimalAndBreed(
                 animal.getKindOfAnimal(),
                 animal.getAgeOfAnimal(),
                 animal.getBreed())!=null){
             errors.rejectValue("kindOfAnimal","","Такое животное уже существует!");
         }
    }
}
