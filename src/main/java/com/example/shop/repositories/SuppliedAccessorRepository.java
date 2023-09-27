package com.example.shop.repositories;

import com.example.shop.models.Supplied_accessoriesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SuppliedAccessorRepository extends JpaRepository<Supplied_accessoriesModel,Long> {
}
