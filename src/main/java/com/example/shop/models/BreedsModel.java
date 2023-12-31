package com.example.shop.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name="breeds")
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class BreedsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_breeds")
    private Long id_breeds;
    @Column(name="breed")
    @Pattern(regexp = "^[А-ЯЁа-яё]+[\s]?+[А-ЯЁа-яё]+$", message = "Некторректный ввод породы!")
    private String breed;
    @OneToMany(mappedBy = "breed",cascade = CascadeType.ALL)
    private List<AnimalsModel> AnimalsList;

}
