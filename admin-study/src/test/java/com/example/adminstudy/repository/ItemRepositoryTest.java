package com.example.adminstudy.repository;

import com.example.adminstudy.AdminStudyApplicationTests;
import com.example.adminstudy.model.entity.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;


class ItemRepositoryTest extends AdminStudyApplicationTests
{
    @Autowired
    private ItemRepository itemRepository;

    @Test
    @Order(1)
    void create()
    {
        Item item = new Item();

        item.setStatus("UNREGISTERED");
        item.setName("삼성 노트북");
        item.setTitle("삼성 노트북 A100");
        item.setContent("삼성 노트북");
        item.setPrice(100_0000);
        item.setBrandName("SAMSUNG");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("AdminServer");

        Item saveItem = itemRepository.save(item);

        Assertions.assertThat(saveItem).isNotNull();
    }

    @Test
    @Order(2)
    void read()
    {
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        Assertions.assertThat(item.isPresent()).isTrue();
    }
}