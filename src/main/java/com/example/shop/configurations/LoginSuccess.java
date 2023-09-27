package com.example.shop.configurations;

import com.example.shop.controllers.StaffController;
import com.example.shop.models.User;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class LoginSuccess implements ApplicationListener<AuthenticationSuccessEvent> {
    private final StaffController staffController;
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        staffController.user=(User) event.getAuthentication().getPrincipal();

    }
}
