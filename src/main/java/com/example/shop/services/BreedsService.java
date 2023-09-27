package com.example.shop.services;

import com.example.shop.models.BreedsModel;
import com.example.shop.repositories.BreedsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class BreedsService {
    private final BreedsRepository breedsRepository;
    public List<BreedsModel> listBreeds() {
        return breedsRepository.findAll();
    }
    public void saveBreed(BreedsModel breed){
        log.info("Saving new {}",breed);
        breedsRepository.save(breed);
    }
}
