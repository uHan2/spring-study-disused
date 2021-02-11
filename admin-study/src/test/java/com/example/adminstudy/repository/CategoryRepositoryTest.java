package com.example.adminstudy.repository;

import com.example.adminstudy.AdminStudyApplicationTests;
import com.example.adminstudy.model.entity.Category;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryRepositoryTest extends AdminStudyApplicationTests
{
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Order(1)
    void create()
    {
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();

        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);


        assertThat(newCategory).isNotNull();
        assertThat(newCategory.getType()).isEqualTo(type);
        assertThat(newCategory.getTitle()).isEqualTo(title);

    }

    @Test
    @Order(2)
    void read()
    {
        String type = "COMPUTER";
        Optional<Category> optionalCategory = categoryRepository.findByType("Computer");


        optionalCategory.ifPresent(c->
        {
            assertThat(c.getType()).isEqualTo(type);
        });
    }
}