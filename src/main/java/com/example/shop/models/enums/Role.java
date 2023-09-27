package com.example.shop.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_DIRECTOR,ROLE_MANAGER,ROLE_CASHIER;
    @Override
    public String getAuthority() {
        return name();
    }
}
