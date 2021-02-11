package com.example.adminstudy.repository;

import com.example.adminstudy.AdminStudyApplicationTests;
import com.example.adminstudy.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class OrderDetailRepositoryTest extends AdminStudyApplicationTests
{
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    void create()
    {
        OrderDetail orderDetail = new OrderDetail();

        OrderDetail saveOrderDetail = orderDetailRepository.save(orderDetail);

        assertThat(saveOrderDetail).isNotNull();

    }

}