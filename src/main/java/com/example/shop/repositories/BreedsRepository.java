package com.example.shop.repositories;

import com.example.shop.models.BreedsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BreedsRepository extends JpaRepository<BreedsModel,Long> {
}
