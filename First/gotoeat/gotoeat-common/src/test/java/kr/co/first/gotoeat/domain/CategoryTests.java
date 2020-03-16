package kr.co.first.gotoeat.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CategoryTests
{
    @Test
    public void creation()
    {
        Category category = Category.builder().name("Korean Food").build();

        assertThat(category.getName(), is("Korean Food"));
    }

}