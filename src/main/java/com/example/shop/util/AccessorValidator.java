package com.example.shop.util;

import com.example.shop.models.AccessoriesModel;
import com.example.shop.repositories.AccessoriesRepository;
import com.example.shop.services.AccessoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AccessorValidator implements Validator {

    private final AccessoriesRepository accessoriesRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors){
        AccessoriesModel accessor = (AccessoriesModel) target;
        AccessoriesModel desiredAccessor =
                accessoriesRepository.findAccessoriesModelByNameOfAccessorAndPriceOfAccessorAndManufacturerOfAccessorAndAnimal(
                accessor.getNameOfAccessor(),
                accessor.getPriceOfAccessor(),
                accessor.getManufacturerOfAccessor(),
                accessor.getAnimal());
        if(desiredAccessor!=null && !Objects.equals(desiredAccessor.getId_accessories(), accessor.getId_accessories())){
            errors.rejectValue("nameOfAccessor","","Такой аксессуар уже существует!");
        }
    }
}
