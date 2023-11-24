package com.example.shop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="sales")
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class SalesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_sales")
    private Long id_sales;
    @Column(name="date_of_sale")
    private String dateOfSale;
    @ManyToOne
    @JoinColumn(name="staff_id_for_sale")
    private StaffModel staff_id_for_sale;
    @OneToMany(mappedBy = "id.sale",cascade = CascadeType.ALL)
    private List<Sold_feedsModel> sold_feedsModelList;
    @OneToMany(mappedBy = "id.sale",cascade = CascadeType.ALL)
    private List<Sold_accessoriesModel> sold_accessoriesModelList;
    @PrePersist
    private void init(){
        dateOfSale=String.valueOf(LocalDate.now());
    }
}
