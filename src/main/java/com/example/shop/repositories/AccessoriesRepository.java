package com.example.shop.repositories;

import com.example.shop.models.AccessoriesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AccessoriesRepository extends JpaRepository<AccessoriesModel,Long> {
    List<AccessoriesModel> findAccessoriesModelByNameOfAccessorContaining (String nameOfAccessor);
}
