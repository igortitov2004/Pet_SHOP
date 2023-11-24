package com.example.shop.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Embeddable
@RequiredArgsConstructor
@EqualsAndHashCode
public class CompositForSupplFeeds implements Serializable {

    private SuppliesModel supply;
    private FeedsModel feed;
    public CompositForSupplFeeds(SuppliesModel supply, FeedsModel feed){
        this.supply=supply;
        this.feed=feed;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    public SuppliesModel getSupply(){
        return supply;
    }
    public void setSupply(SuppliesModel supply){
        this.supply=supply;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    public FeedsModel getFeed(){
        return feed;
    }
    public void setFeed(FeedsModel feed){
        this.feed=feed;
    }
}
