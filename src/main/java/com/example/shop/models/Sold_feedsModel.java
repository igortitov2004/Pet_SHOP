package com.example.shop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="sold_feeds")
@AllArgsConstructor
@Data
@NoArgsConstructor
@AssociationOverrides({
        @AssociationOverride(name = "id.sale",joinColumns = @JoinColumn(name = "id_sales_for_feeds")),
        @AssociationOverride(name = "id.feed",joinColumns = @JoinColumn(name = "feed_id_for_sale"))
})
public class Sold_feedsModel {

    CompositForSoldFeeds id = new CompositForSoldFeeds();

    private int amount;
   @Column(name="id_sales_for_feeds")
    private SalesModel sale;

  @Column(name="feed_id_for_sale")
    private FeedsModel feed;


   @EmbeddedId
    public CompositForSoldFeeds getId(){
        return id;
    }
    public void setId(CompositForSoldFeeds id){
        this.id=id;
    }


    @Column(name = "amount_of_sold_feed")
    public int getAmount(){
        return amount;
    }
    @Column(name = "amount_of_sold_feed")
    public void setAmount(int amount){
        this.amount=amount;
    }


    @Transient
    public SalesModel getSale(){
        return sale;
    }
    public void setSale(SalesModel sale){
        this.sale=sale;
    }
    @Transient
    public FeedsModel getFeed(){
        return feed;
    }
    public void setFeed(FeedsModel feed){
        this.feed=feed;
    }

}


