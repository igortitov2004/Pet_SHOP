package com.example.shop.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="feeds")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class FeedsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_feeds")
    private Long id_feeds;

    @Column(name="name_of_feed")
    @Pattern(regexp = "^[А-ЯЁа-яёA-Za-z]+[\s]?+[А-ЯЁа-яёA-Za-z]+$", message = "Некторректный ввод названия корма!")
    private String nameOfFeed;
//    @Column(name="animal_id_for_feed")
//    private String  animal_id_for_feed;
    @Column(name="price_of_feed")
    private double price_of_feed;
    @Column(name="weight_of_feed")
    private double weight_of_feed;

    @Column(name="manufacturer_of_feed")
    @Pattern(regexp = "^[А-ЯЁа-яёA-Za-z]+[\s]?+[А-ЯЁа-яёA-Za-z]+$", message = "Некторректный ввод производителя!")
    private String manufacturer_of_feed;
    @Column(name="amount_of_feeds")
    private int amount_of_feeds;

    @ManyToOne
    @JoinColumn(name="animal_id_for_feed")
    private AnimalsModel animal_id_for_feed;
    @OneToMany(mappedBy = "id.feed",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Sold_feedsModel> sold_feedsModelList;

    @OneToMany(mappedBy = "id.feed",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Supplied_feedsModel> supplied_feedsModelList;




}
