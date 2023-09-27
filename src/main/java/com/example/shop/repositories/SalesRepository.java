package com.example.shop.repositories;

import com.example.shop.models.SalesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface SalesRepository extends JpaRepository<SalesModel,Long> {
    List<SalesModel> findSalesModelByDateOfSaleContaining (String dateOfSale);
}