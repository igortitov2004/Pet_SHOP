package com.example.shop.repositories;

import com.example.shop.models.Sold_accessoriesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SoldAccessorRepository extends JpaRepository<Sold_accessoriesModel,Long> {
}
