package kr.co.first.gotoeat.domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository
{
    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepository()
    {
        restaurants.add(new Restaurant(1004, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020, "Cyber Food", "Seoul"));
    }

    public List<Restaurant> findAll()
    {
        return restaurants;
    }

    public Restaurant findById(int id)
    {
        return restaurants.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
