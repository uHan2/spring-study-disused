package com.example.adminstudy.repository;

import com.example.adminstudy.AdminStudyApplicationTests;
import com.example.adminstudy.model.entity.AdminUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class AdminUserRepositoryTest extends AdminStudyApplicationTests
{
    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    void create()
    {
        AdminUser adminUser = new AdminUser();

        adminUser.setAccount("AdminUser01");
        adminUser.setPassword("test");
        adminUser.setStatus("REGISTERED");
        adminUser.setRole("SUPER");

        AdminUser newAdminUser = adminUserRepository.save(adminUser);

        assertThat(newAdminUser).isNotNull();
    }

}