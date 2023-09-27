package com.example.shop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name="breeds")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class BreedsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_breeds")
    private Long id_breeds;
    @Column(name="breed")
    private String breed;



    @OneToMany(mappedBy = "breed_id",cascade = CascadeType.ALL)
    private List<AnimalsModel> AnimalsList;

}