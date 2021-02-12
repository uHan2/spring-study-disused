package com.example.adminstudy.repository;

import com.example.adminstudy.AdminStudyApplicationTests;
import com.example.adminstudy.model.entity.OrderGroup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class OrderGroupRepositoryTest extends AdminStudyApplicationTests
{
    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    void create()
    {
        OrderGroup orderGroup = new OrderGroup();

        orderGroup.setStatus("COMPLETE");
        orderGroup.setOrderType("CARD");
        orderGroup.setRevAddress("test");
        orderGroup.setRevName("KIM");
        orderGroup.setPaymentType("CARD");
        orderGroup.setTotalPrice(BigDecimal.valueOf(90000));
        orderGroup.setTotalQuantity(1);
        orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
        orderGroup.setArrivalDate(LocalDateTime.now());
        orderGroup.setCreatedAt(LocalDateTime.now());
        orderGroup.setCreatedBy("AdminServer");

        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);

        assertThat(newOrderGroup).isNotNull();
    }

}