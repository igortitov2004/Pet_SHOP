package com.example.shop.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="feeds")
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class FeedsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_feeds")
    private Long id_feeds;

    @Column(name="name_of_feed")
    @Pattern(regexp = "^[А-ЯЁа-яёA-Za-z]+[\s]?+[А-ЯЁа-яёA-Za-z]+$", message = "Некторректный ввод названия корма!")
    private String nameOfFeed;
    @Column(name="price_of_feed")
    private double priceOfFeed;
    @Column(name="weight_of_feed")
    private double weightOfFeed;

    @Column(name="manufacturer_of_feed")
    @Pattern(regexp = "^[А-ЯЁа-яёA-Za-z]+[\s]?+[А-ЯЁа-яёA-Za-z]+$", message = "Некторректный ввод производителя!")
    private String manufacturerOfFeed;
    @Column(name="amount_of_feeds")
    private int amountOfFeeds;

    @ManyToOne
    @JoinColumn(name="animal_id_for_feed")
    private AnimalsModel animal;
    @OneToMany(mappedBy = "id.feed",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Sold_feedsModel> sold_feedsModelList;

    @OneToMany(mappedBy = "id.feed",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Supplied_feedsModel> supplied_feedsModelList;




}
