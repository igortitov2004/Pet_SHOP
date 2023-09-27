package com.example.shop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="supplies")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class SuppliesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_supplies")
    private Long id_supplies;
    @Column(name="date_of_suppl")
    private String dateOfSuppl;
    @ManyToOne
    @JoinColumn(name="staff_id_for_suppl")
    private StaffModel staff_id_for_suppl;
    @OneToMany(mappedBy = "id.supply",cascade = CascadeType.ALL)
    private List<Supplied_feedsModel> supplied_feedsModelList;
    @OneToMany(mappedBy = "id.supply",cascade = CascadeType.ALL)
    private List<Supplied_accessoriesModel> supplied_accessoriesModelList;
    @PrePersist
    private void init(){
        dateOfSuppl=String.valueOf(LocalDate.now());
    }
}
