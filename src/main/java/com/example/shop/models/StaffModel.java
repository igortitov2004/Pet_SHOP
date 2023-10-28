package com.example.shop.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Pattern(regexp = "([А-ЯЁ][а-яё]+[\\-\\s]?){3,}", message = "Некорректный ввод ФИО")
    private String fullName;
    @Column(name="num_of_passport")
    @Pattern(regexp = "(АВ|ВМ|НВ|КН|МР|МС|КВ|РР)\\d{7}", message = "Некорректный номер паспорта (пример: НВ1234567)")
    private String num_of_passport;
    @Column(name="tel_number")
    @Pattern(regexp = "\\+375(17|25|29|33|44)\\d{7}", message = "Некорректный ввод номера телефона (пример: +375331234567)")
    private String telNumber;
    @Column(name="experience")
    @Min(0)
    @Max(value = 50,message = "Максимальный стаж 50")
    private Integer experience;
    @OneToMany(mappedBy = "staff_id_for_sale")
    private List<SalesModel> salesList;
    @OneToMany(mappedBy = "staff_id_for_suppl")
    private List<SuppliesModel> supplieslList;
    @Column(name="job_title")
    private String job_title;
    @OneToOne(mappedBy = "staff")
    private User user;














}