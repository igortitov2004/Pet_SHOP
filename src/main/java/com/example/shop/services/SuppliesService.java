package com.example.shop.services;

import com.example.shop.models.*;
import com.example.shop.repositories.SuppliedAccessorRepository;
import com.example.shop.repositories.SuppliedFeedsRepository;
import com.example.shop.repositories.SuppliesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SuppliesService {
    private final SuppliesRepository suppliesRepository;
    private final SuppliedFeedsRepository suppliedFeedsRepository;
    private final SuppliedAccessorRepository suppliedAccessorRepository;
    public List<SuppliesModel> listSupplies(String dateOfSuppl) {
        if(dateOfSuppl!=null) return suppliesRepository.findSuppliesModelByDateOfSupplContaining(dateOfSuppl);
        return suppliesRepository.findAll();
    }
    public SuppliesModel addFeedInSupply(SuppliesModel supply, FeedsModel feed, int amount){
        Supplied_feedsModel suppliedFeed=new Supplied_feedsModel();
        suppliedFeed.setFeed(feed);
        suppliedFeed.setSale(supply);
        suppliedFeed.setAmount(amount);
        suppliedFeed.setId(new CompositForSupplFeeds(supply,feed));
        supply.getSupplied_feedsModelList().add(suppliedFeed);
        return supply;
    }
    public SuppliesModel addAccessorInSupply(SuppliesModel supply, AccessoriesModel accessor,int amount){
        Supplied_accessoriesModel suppliedAccessor=new Supplied_accessoriesModel();
        suppliedAccessor.setAccessor(accessor);
        suppliedAccessor.setAmount(amount);
        suppliedAccessor.setId(new CompositForSupplAccessor(supply,accessor));
        supply.getSupplied_accessoriesModelList().add(suppliedAccessor);
        return supply;
    }
    public void saveSupply(SuppliesModel supply){
        suppliesRepository.save(supply);
    }
    public SuppliesModel deleteSuppliedFeed(int index,SuppliesModel supply){
        supply.getSupplied_feedsModelList().remove(index);
        return supply;
    }
    public SuppliesModel deleteSuppliedAccessor(int index,SuppliesModel supply){
        supply.getSupplied_accessoriesModelList().remove(index);
        return supply;
    }
    public void deleteSupply( Long id_supplies){
        suppliesRepository.deleteById(id_supplies);
    }
    public SuppliesModel getSupplyById(Long id_supplies) {
        return suppliesRepository.findById(id_supplies).orElse(null);
    }

    public List<FeedsModel> getListOfAvailableFeeds(SuppliesModel supply, List<FeedsModel> list){
        for (Supplied_feedsModel suppliedFeed: supply.getSupplied_feedsModelList()) {
            list=list.stream().filter(o-> !Objects.equals(o.getNameOfFeed(), suppliedFeed.getFeed().getNameOfFeed())).collect(Collectors.toList());
        }
        return list;
    }
    public List<AccessoriesModel> getListOfAvailableAccessories(SuppliesModel supply, List<AccessoriesModel> list){
        for (Supplied_accessoriesModel suppliedAccessor: supply.getSupplied_accessoriesModelList()) {
            list=list.stream().filter(o-> !Objects.equals(o.getNameOfAccessor(), suppliedAccessor.getAccessor().getNameOfAccessor())).collect(Collectors.toList());
        }
        return list;
    }
}
