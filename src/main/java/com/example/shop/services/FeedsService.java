package com.example.shop.services;

import com.example.shop.models.FeedsModel;
import com.example.shop.models.SalesModel;
import com.example.shop.models.Sold_feedsModel;
import com.example.shop.models.StaffModel;
import com.example.shop.repositories.FeedsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class FeedsService {
    private final FeedsRepository feedsRepository;
    public List<FeedsModel> listFeeds(String nameofFeed) {
        if(nameofFeed!=null) return feedsRepository.findFeedsModelByNameOfFeedContaining(nameofFeed);
        return feedsRepository.findAll();
    }
    public void saveFeed(FeedsModel feeds){
        feedsRepository.save(feeds);
    }

    public void update(Long id, FeedsModel feedsModel){
        FeedsModel feed = getFeedById(id);
        feed.setPriceOfFeed(feedsModel.getPriceOfFeed());
        feedsRepository.save(feed);
    }
    public int getAmountOfSold(SalesModel sale, Long id_feeds){
        int soldAmount = sale.getSold_feedsModelList()
                .stream()
                .filter(o->o.getFeed().getId_feeds().equals(id_feeds)).findFirst().map(Sold_feedsModel::getAmount).orElse(0);
        return getFeedById(id_feeds).getAmountOfFeeds() - soldAmount;
    }
    public void deleteFeed( Long id_feeds){
        feedsRepository.deleteById(id_feeds);
    }
    public FeedsModel getFeedById(Long id_feeds){
        return feedsRepository.findById(id_feeds).orElse(null);
    }
}
