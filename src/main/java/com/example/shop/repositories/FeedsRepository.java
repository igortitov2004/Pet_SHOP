package com.example.shop.repositories;

import com.example.shop.models.AnimalsModel;
import com.example.shop.models.FeedsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface FeedsRepository extends JpaRepository<FeedsModel,Long> {
    List<FeedsModel> findFeedsModelByNameOfFeedContaining (String nameOfFeed);
    FeedsModel findFeedsModelByNameOfFeedAndManufacturerOfFeedAndPriceOfFeedAndWeightOfFeedAndAnimal(String name, String manufacturer, double price, double weight, AnimalsModel animal);
}
