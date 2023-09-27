package com.example.shop.models;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
@Embeddable
@RequiredArgsConstructor
public class CompositForSoldFeeds implements Serializable {

    private SalesModel sale;
    private FeedsModel feed;
    public CompositForSoldFeeds(SalesModel sale, FeedsModel feed){
        this.sale=sale;
        this.feed=feed;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    public SalesModel getSale(){
        return sale;
    }
    public void setSale(SalesModel sale){
        this.sale=sale;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    public FeedsModel getFeed(){
        return feed;
    }
    public void setFeed(FeedsModel feed){
        this.feed=feed;
    }



}
