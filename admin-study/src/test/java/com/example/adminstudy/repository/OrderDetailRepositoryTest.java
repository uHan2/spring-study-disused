package com.example.adminstudy.repository;

import com.example.adminstudy.AdminStudyApplicationTests;
import com.example.adminstudy.model.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


class OrderDetailRepositoryTest extends AdminStudyApplicationTests
{
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    void create()
    {
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setStatus("WAITING");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(90000));
        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("AdminServer");

        OrderDetail saveOrderDetail = orderDetailRepository.save(orderDetail);

        assertThat(saveOrderDetail).isNotNull();

    }

}