package com.example.shop.repositories;

import com.example.shop.models.AnimalsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository

public interface AnimalsRepository extends JpaRepository<AnimalsModel,Long> {
    List<AnimalsModel>  findAnimalsModelByKindOfAnimalContaining(String kindOfAnimal);
}
