package com.example.shop.repositories;

import com.example.shop.models.Supplied_feedsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SuppliedFeedsRepository extends JpaRepository<Supplied_feedsModel,Long>{
}
