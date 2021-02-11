package com.example.adminstudy.repository;

import com.example.adminstudy.AdminStudyApplicationTests;
import com.example.adminstudy.model.entity.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class UserRepositoryTest extends AdminStudyApplicationTests
{
    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    void create()
    {
        String account = "Test01";
        String password = "Test01";
        String status = "registered";
        String email = "test01@gmail.com";
        String phoneNumber = "010-test-test";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();

        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);

        assertThat(newUser).isNotNull();
    }

    @Test
    @Order(2)
    void read()
    {
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-test-test");

        assertThat(user).isNotNull();
    }

}