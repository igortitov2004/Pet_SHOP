package com.example.shop.models;

import com.example.shop.models.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Entity
@Table(name="staff")
@AllArgsConstructor
@Data
@NoArgsConstructor

public class StaffModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_staff")
    private Long id_staff;
    @Column(name="full_name")
    private String fullName;
    @Column(name="num_of_passport")
    private String num_of_passport;
    @Column(name="tel_number")
    private String telNumber;
    @Column(name="experience")
    private int experience;
    @OneToMany(mappedBy = "staff_id_for_sale")
    private List<SalesModel> salesList;
    @OneToMany(mappedBy = "staff_id_for_suppl")
    private List<SuppliesModel> supplieslList;
    @Column(name="job_title")
    private String job_title;
    @OneToOne(mappedBy = "staff")
    private User user;














}