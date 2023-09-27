package com.example.shop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Entity
@Table(name="animals")
@AllArgsConstructor
@Data
@NoArgsConstructor

public class AnimalsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_animals")
    private Long id_animals;
    @Column(name="kind_of_animal")

    private String kindOfAnimal;
//    @Column(name="breed_id")
//    private Long breed_id;
    @Column(name="weight_of_animal")
    private String weight_of_animal;
    @Column(name="age_of_animal")
    private int age_of_animal;

    @OneToMany(mappedBy = "animal_id_for_accessor")
    private List<AccessoriesModel> AccessorList;
    @OneToMany(mappedBy = "animal_id_for_feed")
    private List<FeedsModel> FeedsList;

    @ManyToOne
    @JoinColumn(name="breed_id")
    private BreedsModel breed_id;



}
