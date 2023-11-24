package com.example.shop.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "([А-ЯЁ][а-яё]+[\\-\\s]?){3,}", message = "Некорректный ввод Ф.И.О.")
    private String fullName;
    @Column(name="num_of_passport")
    @Pattern(regexp = "(АВ|ВМ|НВ|КН|МР|МС|КВ|РР)\\d{7}", message = "Некорректный номер паспорта (пример: НВ1234567)")
    private String numOfPassport;
    @Column(name="tel_number")
    @Pattern(regexp = "\\+375(17|25|29|33|44)\\d{7}", message = "Некорректный ввод номера телефона (пример: +375(Код оператора)1234567)")
    private String telNumber;
    @Column(name="experience")
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