package com.example.shop.util;

import com.example.shop.models.FeedsModel;
import com.example.shop.repositories.FeedsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class FeedValidator implements Validator {
    private final FeedsRepository feedsRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return FeedsModel.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors){
        FeedsModel feed = (FeedsModel) target;
        FeedsModel desiredFeed = feedsRepository.findFeedsModelByNameOfFeedAndManufacturerOfFeedAndPriceOfFeedAndWeightOfFeedAndAnimal(
                feed.getNameOfFeed(),
                feed.getManufacturerOfFeed(),
                feed.getPriceOfFeed(),
                feed.getWeightOfFeed(),
                feed.getAnimal());
        if(desiredFeed!=null && !Objects.equals(desiredFeed.getId_feeds(), feed.getId_feeds())){
            errors.rejectValue("nameOfFeed","","Такой корм уже существует");
        }
    }
}
