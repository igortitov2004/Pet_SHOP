package com.example.shop.controllers;

import com.example.shop.models.AccessoriesModel;
import com.example.shop.models.FeedsModel;
import com.example.shop.models.StaffModel;
import com.example.shop.repositories.FeedsRepository;
import com.example.shop.services.AnimalsService;
import com.example.shop.services.FeedsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_DIRECTOR','ROLE_MANAGER','ROLE_CASHIER')")
public class FeedsController {
    private final FeedsService feedsService;
    private final AnimalsService animalsService;
    private final FeedsRepository feedsRepository;

    private final StaffController staffController;
    @GetMapping("/feeds")
    public String feeds(@RequestParam(name = "nameOfFeed", required = false) String nameOfFeed, Model model){
        model.addAttribute("feeds", feedsService.listFeeds(nameOfFeed));
        model.addAttribute("animals",animalsService.listAnimals(null));
        model.addAttribute("user", staffController.user);
        return "feeds";
    }
        @GetMapping("/feeds/{id_feeds}")
    public String feedsInfo(@PathVariable Long id_feeds, Model model){
        model.addAttribute("feeds", feedsService.getFeedById(id_feeds));
        return "feeds-info";
    }
    @PostMapping("/feeds/create")
    public String createFeed(FeedsModel feed){
        feedsService.saveFeed(feed);
        return "redirect:/feeds";

    }
    @PostMapping("/feeds/delete/{id_feeds}")
    public String deleteAccessor(@PathVariable Long id_feeds){
        feedsService.deleteFeed(id_feeds);
        return "redirect:/feeds";

    }
    @GetMapping("/feeds/{id_feeds}/edit")
    public String startEditFeed(@PathVariable(value = "id_feeds") Long id_feeds ,Model model){
        model.addAttribute("feeds",feedsService.getFeedById(id_feeds));
        return "edit-feed";
    }
    @PostMapping("/feeds/{id_feeds}/edit")
    public String editFeed(@PathVariable(value = "id_feeds") Long id_feeds , FeedsModel feedsModel){
        FeedsModel feed=feedsService.getFeedById(id_feeds) ;
        feed.setPrice_of_feed(feedsModel.getPrice_of_feed());
             feedsRepository.save(feed);
        return "redirect:/feeds";
    }
}
