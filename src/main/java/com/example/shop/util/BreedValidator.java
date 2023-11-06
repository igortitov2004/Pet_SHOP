package com.example.shop.util;

import com.example.shop.models.BreedsModel;
import com.example.shop.repositories.BreedsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
@RequiredArgsConstructor
public class BreedValidator implements Validator {

    private final BreedsRepository breedsRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return BreedsModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BreedsModel breed = (BreedsModel) target;
        if(breedsRepository.findBreedsModelByBreed(breed.getBreed())!=null){
            errors.rejectValue("breed","","Такая порода уже существует!");
        }

    }
}
