package com.example.adminstudy.repository;

import com.example.adminstudy.AdminStudyApplicationTests;
import com.example.adminstudy.model.entity.User;
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
    void create()
    {
        User user = new User();
        user.setAccount("testID");
        user.setEmail("test@test.com");
        user.setPhoneNumber("010-test-test");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("testAdmin");

        User saveUser = userRepository.save(user);
        System.out.println("saveUser = " + saveUser);
    }

    @Test
    @Transactional
    void read()
    {
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(findUser ->
        {
            findUser.getOrderDetailList().stream().forEach(detail ->
            {
                System.out.println("@@@@ :: " + detail.getId());
            });
        });
    }

    @Test
    @Transactional
    void update()
    {
        Optional<User> user = userRepository.findById(9L);

        user.ifPresent(findUser ->
        {
            System.out.println("before findUser = " + findUser);
            findUser.setAccount("updateAccount");
            findUser.setUpdatedAt(LocalDateTime.now());
            findUser.setUpdatedBy("updateTest");

            System.out.println("after findUser = " + findUser);
        });

    }

    @Test
    @Transactional
    void delete()
    {
        Optional<User> user = userRepository.findById(1L);

        assertThat(user.isPresent()).isTrue();

        user.ifPresent(findUser ->
        {
            userRepository.delete(findUser);
        });

        Optional<User> deleteUser = userRepository.findById(1L);

        assertThat(deleteUser.isPresent()).isFalse();
    }
}