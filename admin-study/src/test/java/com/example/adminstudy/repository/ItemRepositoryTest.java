package com.example.adminstudy.repository;

import com.example.adminstudy.AdminStudyApplicationTests;
import com.example.adminstudy.model.entity.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


class ItemRepositoryTest extends AdminStudyApplicationTests
{
    @Autowired
    private ItemRepository itemRepository;

    @Test
    void create()
    {
        Item item = new Item();

        item.setName("노트북");
        item.setPrice(100_0000);
        item.setContent("삼성 노트북");

        Item saveItem = itemRepository.save(item);

        System.out.println("saveItem = " + saveItem);

        Assertions.assertThat(saveItem).isNotNull();
    }

    @Test
    void read()
    {
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        Assertions.assertThat(item.isPresent()).isTrue();
    }
}