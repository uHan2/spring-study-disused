package com.example.adminstudy.repository;

import com.example.adminstudy.AdminStudyApplicationTests;
import com.example.adminstudy.model.entity.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

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

    /**
     * LazyInitializationException 빌생. 아마 데이터를 제대로 셋팅하고 테스트 해야할듯
     */
    @Test
    @Order(2)
    void read()
    {
        User findUser = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-test-test");

        if (findUser != null)
        {
            findUser.getOrderGroupList().forEach((orderGroup ->
            {
                System.out.println("orderGroup.getT = " + orderGroup.getTotalPrice());
                System.out.println("orderGroup.getRevAddress() = " + orderGroup.getRevAddress());
                System.out.println("orderGroup.getTotalQuantity() = " + orderGroup.getTotalQuantity());

                orderGroup.getOrderDetailList().forEach(orderDetail ->
                {
                    System.out.println("orderDetail.getStatus() = " + orderDetail.getStatus());
                    System.out.println("orderDetail.getArrivalDate() = " + orderDetail.getArrivalDate());
                });

            }));
        }


        assertThat(findUser).isNotNull();
    }

}