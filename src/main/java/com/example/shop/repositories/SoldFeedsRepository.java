package com.example.shop.repositories;

import com.example.shop.models.Sold_feedsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SoldFeedsRepository extends JpaRepository<Sold_feedsModel,Long> {
}
