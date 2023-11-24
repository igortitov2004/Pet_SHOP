package com.example.shop.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name="animals")
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class AnimalsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_animals")
    private Long id_animals;
    @Column(name="kind_of_animal")
    @Pattern(regexp = "^\\p{InCyrillic}+", message = "Вид животного должен состоять только из русских букв!")
//    @Size(min = 3,message = "Некорректная длина вида животного!")
    private String kindOfAnimal;
//    @Column(name="breed_id")
//    private Long breed_id;
    @Column(name="weight_of_animal")
//    @DecimalMin(value = "0.01",message = "Некорректный ввод!")
//    @DecimalMax(value = "50.0",message = "Максимально допустимый вес 50 кг!")
//    @Positive(message = "Некорректный ввод!") @Max(value = 50,message = "Максимально допустимый вес 50 кг!")
    private double weight_of_animal;
    @Column(name="age_of_animal")
//    @Min(value = 0,message = "Некорректный ввод!")
//    @Max(value = 30,message = "Максимально допустимый возраст 30 лет!")
    private Integer ageOfAnimal;
    @OneToMany(mappedBy = "animal")
    private List<AccessoriesModel> AccessorList;
    @OneToMany(mappedBy = "animal")
    private List<FeedsModel> FeedsList;

    @ManyToOne
    @JoinColumn(name="breed_id")
    private BreedsModel breed;



}
