package com.example.shop.repositories;

import com.example.shop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByLogin(String login);
    User findUserByTelNumber(String tel_number);
}
