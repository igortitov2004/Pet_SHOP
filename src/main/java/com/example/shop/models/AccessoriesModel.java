package com.example.shop.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name="accessories")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class AccessoriesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_accessories")
    private Long id_accessories;
    @Column(name="name_of_accessor")
    @Pattern(regexp = "^[А-ЯЁа-яёA-Za-z]+[\s]?+[А-ЯЁа-яёA-Za-z]+$",
            message = "Некторректный ввод названия аксессуара!\n" +
                    " Строка должна состоять только из букв")
    private String nameOfAccessor;
//    @Column(name="animal_id_for_accessor")
//    private String  animal_id_for_accessor;
    @Column(name="price_of_accessor")
    private double priceOfAccessor;
    @Pattern(regexp = "^[А-ЯЁа-яёA-Za-z]+[\s]?+[А-ЯЁа-яёA-Za-z]+$",
            message = "Некторректный ввод производителя аксессуара!\n" +
                    " Строка должна состоять только из букв")
    @Column(name="manufacturer_of_accessor")
    private String manufacturerOfAccessor;
    @Column(name = "amount_of_accessories")
    private int amount_of_accessories;
    @ManyToOne
    @JoinColumn(name="animal_id_for_accessor")
    private AnimalsModel animal;
    @OneToMany(mappedBy = "id.accessor",cascade = CascadeType.ALL)
    private List<Sold_accessoriesModel> sold_accessoriesModel;

    @OneToMany(mappedBy = "id.accessor",cascade = CascadeType.ALL)
    private List<Supplied_accessoriesModel> supplied_accessoriesModelList;
}
