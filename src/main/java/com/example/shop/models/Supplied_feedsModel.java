package com.example.shop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="supplied_feeds")
@AllArgsConstructor
@Data
@NoArgsConstructor
@AssociationOverrides({
        @AssociationOverride(name = "id.supply",joinColumns = @JoinColumn(name = "id_supply_for_feeds")),
        @AssociationOverride(name = "id.feed",joinColumns = @JoinColumn(name = "feed_id_for_supplies"))
})
@EqualsAndHashCode
public class Supplied_feedsModel {
    CompositForSupplFeeds id = new CompositForSupplFeeds();
    private int amount;
    @Column(name="id_supply_for_feeds")
    private SuppliesModel supply;
    @Column(name="feed_id_for_supplies")
    private FeedsModel feed;
    @EmbeddedId
    public CompositForSupplFeeds getId(){
        return id;
    }
    public void setId(CompositForSupplFeeds id){
        this.id=id;
    }
    @Column(name = "amount_of_supplied_feeds")
    public int getAmount(){
        return amount;
    }
    @Column(name = "amount_of_supplied_feeds")
    public void setAmount(int amount){
        this.amount=amount;
    }
    @Transient
    public SuppliesModel getSupply(){
        return supply;
    }
    public void setSale(SuppliesModel supply){
        this.supply=supply;
    }
    @Transient
    public FeedsModel getFeed(){
        return feed;
    }
    public void setFeed(FeedsModel feed){
        this.feed=feed;
    }
}
