package com.example.shop.services;

import com.example.shop.models.AccessoriesModel;
import com.example.shop.models.SalesModel;
import com.example.shop.models.Sold_accessoriesModel;
import com.example.shop.models.Sold_feedsModel;
import com.example.shop.repositories.AccessoriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class AccessoriesService {
    private final AccessoriesRepository accessoriesRepository;
    public List<AccessoriesModel> listAccessories(String nameofAccessor) {
        if(nameofAccessor!=null) return accessoriesRepository.findAccessoriesModelByNameOfAccessorContaining(nameofAccessor);
        return accessoriesRepository.findAll();
    }
    public void saveAccessor(AccessoriesModel accessories){
        accessoriesRepository.save(accessories);
    }
    public int getAmountOfSold(SalesModel sale, Long id_accessories){
        int soldAmount = sale.getSold_accessoriesModelList()
                .stream()
                .filter(o->o.getAccessor().getId_accessories().equals(id_accessories)).findFirst().map(Sold_accessoriesModel::getAmount).orElse(0);
        return getAccessorById(id_accessories).getAmount_of_accessories() - soldAmount;
    }
    public void deleteAccessor( Long id_accessories){
        accessoriesRepository.deleteById(id_accessories);
    }
    public AccessoriesModel getAccessorById(Long id_accessories){
        return accessoriesRepository.findById(id_accessories).orElse(null);
    }
}
