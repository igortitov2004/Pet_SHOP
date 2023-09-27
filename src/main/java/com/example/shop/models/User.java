package com.example.shop.models;

import com.example.shop.models.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Entity
@Table(name="users")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Validated

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_user")
    private Long id_user;
    @Column(name="id_role")
    private Role id_role;
    @Column(name="login")
    private String login;
    @Column(name="password", length = 1000)
    private String password;

    @Column(name="tel_number")
    private String telNumber;
    @OneToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id_staff")
    private StaffModel staff;


    public boolean isDirector(){
        return id_role.equals(Role.ROLE_DIRECTOR);
    }
    public boolean isManager(){
        return id_role.equals(Role.ROLE_MANAGER);
    }
    public boolean isCashier(){
        return id_role.equals(Role.ROLE_CASHIER);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(id_role);
    }
    @Override
    public String getUsername() {
        return login;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
