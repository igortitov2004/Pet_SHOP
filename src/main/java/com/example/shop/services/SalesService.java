package com.example.shop.services;

import com.example.shop.models.*;
import com.example.shop.repositories.SalesRepository;
import com.example.shop.repositories.SoldAccessorRepository;
import com.example.shop.repositories.SoldFeedsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class SalesService {
    private final SalesRepository salesRepository;
    private final SoldFeedsRepository soldFeedsRepository;
    private final SoldAccessorRepository soldAccessorRepository;
    public List<SalesModel> listSales(String dateOfSale) {
        if(dateOfSale!=null) return salesRepository.findSalesModelByDateOfSaleContaining(dateOfSale);
        return salesRepository.findAll();
    }
    public SalesModel addFeedInSale(SalesModel sale, FeedsModel feed,int amount){
        Sold_feedsModel soldFeed=new Sold_feedsModel();
        soldFeed.setFeed(feed);
        soldFeed.setSale(sale);
        soldFeed.setAmount(amount);
        soldFeed.setId(new CompositForSoldFeeds(sale,feed));
        sale.getSold_feedsModelList().add(soldFeed);
        return sale;
    }
    public SalesModel addAccessorInSale(SalesModel sale, AccessoriesModel accessor,int amount){
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
    public void deleteSale( Long id_sales){
        salesRepository.deleteById(id_sales);
    }
    public SalesModel getSalesById(Long id_sales){
        return salesRepository.findById(id_sales).orElse(null);
    }
}
