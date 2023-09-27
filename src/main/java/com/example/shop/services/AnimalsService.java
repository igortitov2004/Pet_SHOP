package com.example.shop.services;

import com.example.shop.models.AnimalsModel;
import com.example.shop.repositories.AnimalsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class AnimalsService {
    private final AnimalsRepository animalsRepository;
    public List<AnimalsModel> listAnimals(String kindOfAnimal) {
        if(kindOfAnimal!=null) return animalsRepository.findAnimalsModelByKindOfAnimalContaining(kindOfAnimal);
        return animalsRepository.findAll();
    }
    public void saveAnimal(AnimalsModel animal){
        log.info("Saving new {}",animal);
        animalsRepository.save(animal);
    }
    public void deleteAnimal( Long id_animals){
        animalsRepository.deleteById(id_animals);
    }
    public AnimalsModel getAnimalById(Long id_animals){
        return animalsRepository.findById(id_animals).orElse(null);
    }
}
