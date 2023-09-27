package com.example.shop.repositories;

import com.example.shop.models.SuppliesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface SuppliesRepository extends JpaRepository<SuppliesModel,Long> {
    List<SuppliesModel> findSuppliesModelByDateOfSupplContaining (String dateOfSuppl);
}
