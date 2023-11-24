package com.example.shop.services;

import com.example.shop.models.*;
import com.example.shop.repositories.SalesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SalesService {
    private final SalesRepository salesRepository;
    private final FeedsService feedsService;
    private final AccessoriesService accessoriesService;
    public List<SalesModel> listSales(String dateOfSale) {
        if(dateOfSale!=null) return salesRepository.findSalesModelByDateOfSaleContaining(dateOfSale);
        return salesRepository.findAll();
    }
    public SalesModel addingNewFeedInSale(SalesModel sale, FeedsModel feed,int amount){
        Sold_feedsModel soldFeed=new Sold_feedsModel();
        soldFeed.setFeed(feed);

        soldFeed.setSale(sale);
        soldFeed.setAmount(amount);
        soldFeed.setId(new CompositForSoldFeeds(sale,feed));
        sale.getSold_feedsModelList().add(soldFeed);
        return sale;
    }
    public SalesModel addingNewAccessorInSale(SalesModel sale, AccessoriesModel accessor, int amount){
        Sold_accessoriesModel soldAccessor=new Sold_accessoriesModel();
        soldAccessor.setAccessor(accessor);
        soldAccessor.setAmount(amount);
        soldAccessor.setId(new CompositForSoldAccessor(sale,accessor));
        sale.getSold_accessoriesModelList().add(soldAccessor);
        return sale;
    }
    public void saveSale(SalesModel sale){
        System.out.println("11111");
        salesRepository.save(sale);
    }
    public SalesModel deleteSoldFeed(int index,SalesModel sale){
        sale.getSold_feedsModelList().remove(index);
        return sale;
    }
    public SalesModel deleteSoldAccessor(int index,SalesModel sale){
        sale.getSold_accessoriesModelList().remove(index);
        return sale;
    }
    public SalesModel getSalesById(Long id_sales){
        return salesRepository.findById(id_sales).orElse(null);
    }

    public SalesModel addingFeedsInSale(SalesModel sale,Long id_feeds,int amount){
        FeedsModel feed = feedsService.getFeedById(id_feeds);
        Optional<Sold_feedsModel> soldFeedsModel
                = sale.getSold_feedsModelList()
                .stream()
                .filter(o -> o.getFeed().getId_feeds().equals(feed.getId_feeds())).findFirst();
        if(soldFeedsModel.isPresent()){
            SalesModel finalSale = sale;
            soldFeedsModel.map(p->{
                p.setAmount(p.getAmount()+amount);
                return finalSale;
            });
            System.err.println("Добалено");
        }else {
            sale=addingNewFeedInSale(sale, feedsService.getFeedById(id_feeds),amount);
        }
        return sale;
    }
    public SalesModel addingAccessoriesInSale(SalesModel sale,Long id_accessories,int amount){
        AccessoriesModel accessor = accessoriesService.getAccessorById(id_accessories);
        Optional<Sold_accessoriesModel> soldAccessor
                = sale.getSold_accessoriesModelList()
                .stream()
                .filter(o -> o.getAccessor().getId_accessories().equals(accessor.getId_accessories())).findFirst();
        if(soldAccessor.isPresent()){
            SalesModel finalSale = sale;
            soldAccessor.map(p->{
                p.setAmount(p.getAmount()+amount);
                return finalSale;
            });
            System.err.println("Добалено");
        }else {
            sale=addingNewAccessorInSale(sale, accessoriesService.getAccessorById(id_accessories),amount);
        }
        return sale;
    }
}
