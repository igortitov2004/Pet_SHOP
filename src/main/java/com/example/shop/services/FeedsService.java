package com.example.shop.services;

import com.example.shop.models.FeedsModel;
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
        log.info("Saving new {}",feeds);
        feedsRepository.save(feeds);
    }
    public void deleteFeed( Long id_feeds){
        feedsRepository.deleteById(id_feeds);
    }
    public FeedsModel getFeedById(Long id_feeds){
        return feedsRepository.findById(id_feeds).orElse(null);
    }
}
