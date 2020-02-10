package kr.co.first.gotoeat.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class RestaurantTests
{
    @Test
    public void creation()
    {
        Restaurant restaurant = Restaurant.builder()
                .id(1004)
                .name("Bob zip")
                .location("Seoul")
                .build();

        assertThat(restaurant.getId(), is(1004));
        assertThat(restaurant.getName(), is("Bob zip"));
        assertThat(restaurant.getLocation(), is("Seoul"));
    }

    @Test
    public void information()
    {
        Restaurant restaurant = Restaurant.builder()
                .id(1004)
                .name("Bob zip")
                .location("Seoul")
                .build();

        assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
    }
}