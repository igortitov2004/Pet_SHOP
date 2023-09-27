package com.example.shop.services;

import com.example.shop.models.AccessoriesModel;
import com.example.shop.repositories.AccessoriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class AccessoriesService {
    private final AccessoriesRepository accessoriesRepository;
    public List<AccessoriesModel> listAccessories(String nameofAccessor) {
        if(nameofAccessor!=null) return accessoriesRepository.findAccessoriesModelByNameOfAccessorContaining(nameofAccessor);
        return accessoriesRepository.findAll();
    }
    public void saveAccessor(AccessoriesModel accessories){
        log.info("Saving new {}",accessories);
        accessoriesRepository.save(accessories);
    }
    public void deleteAccessor( Long id_accessories){
        accessoriesRepository.deleteById(id_accessories);
    }
    public AccessoriesModel getAccessorById(Long id_accessories){
        return accessoriesRepository.findById(id_accessories).orElse(null);
    }
}
