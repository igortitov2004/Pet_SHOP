package com.example.shop.controllers;

import com.example.shop.models.FeedsModel;
import com.example.shop.repositories.FeedsRepository;
import com.example.shop.services.AnimalsService;
import com.example.shop.services.FeedsService;
import com.example.shop.util.FeedValidator;
import jakarta.persistence.Transient;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_DIRECTOR','ROLE_MANAGER','ROLE_CASHIER')")
public class FeedsController {
    private final FeedsService feedsService;
    private final AnimalsService animalsService;
    private final FeedsRepository feedsRepository;
    private final StaffController staffController;
    private final FeedValidator feedValidator;
    @GetMapping("/feeds")
    public String feeds(@RequestParam(name = "nameOfFeed", required = false) String nameOfFeed, Model model){
        model.addAttribute("feeds", feedsService.listFeeds(nameOfFeed));
        model.addAttribute("user", staffController.user);
        return "feeds";
    }
    @GetMapping("/feeds/{id_feeds}")
    public String feedsInfo(@PathVariable Long id_feeds, Model model){
        model.addAttribute("feeds", feedsService.getFeedById(id_feeds));
        return "feeds-info";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER','ROLE_CASHIER')")
    @PostMapping("/feeds/delete/{id_feeds}")
    public String deleteFeed(@PathVariable Long id_feeds){
        feedsService.deleteFeed(id_feeds);
        return "redirect:/feeds";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
    @GetMapping("/feeds/create")
    public String startCreateFeed(@ModelAttribute("newFeed") FeedsModel feed, Model model){
        model.addAttribute("animals",animalsService.listAnimals(null));
        feed.setAmountOfFeeds(0);
        feed.setNameOfFeed("");
        feed.setManufacturerOfFeed("");
        feed.setPriceOfFeed(0);
        feed.setWeightOfFeed(0);
        return "feed-creation";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER')")
    @PostMapping("/feeds/create")
    public String createFeed(@Valid @ModelAttribute("newFeed") FeedsModel feed, BindingResult bindingResult,Model model){
        feedValidator.validate(feed,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("animals",animalsService.listAnimals(null));
            model.addAttribute("feedErr",bindingResult.hasErrors());
            return "feed-creation";
        }
        feedsService.saveFeed(feed);
        return "redirect:/feeds";

    }

    @GetMapping("/feeds/{id_feeds}/edit")
    public String startEditFeed(@PathVariable(value = "id_feeds") Long id_feeds, Model model){
        model.addAttribute("feeds",feedsService.getFeedById(id_feeds));
        return "edit-feed";
    }
    @PostMapping("/feeds/{id_feeds}/edit")
    public String editFeed(@PathVariable(value = "id_feeds") Long id_feeds, @Valid @ModelAttribute("feeds") FeedsModel feed,
                           BindingResult bindingResult,Model model){
        FeedsModel modifiedFeed = feedsService.getFeedById(id_feeds);
        modifiedFeed.setPriceOfFeed(feed.getPriceOfFeed());
        feedValidator.validate(modifiedFeed,bindingResult);
        if(bindingResult.hasErrors()){
            feed.setNameOfFeed(modifiedFeed.getNameOfFeed());
            feed.setPriceOfFeed(modifiedFeed.getPriceOfFeed());
            feed.setWeightOfFeed(modifiedFeed.getWeightOfFeed());
            feed.setManufacturerOfFeed(modifiedFeed.getManufacturerOfFeed());
            feed.setAnimal(modifiedFeed.getAnimal());
            model.addAttribute("editFeedErr","Такой корм с этой стоимостью уже существует!");
            return "edit-feed";
        }
        feedsRepository.save(modifiedFeed);
        return "redirect:/feeds";
    }
}
