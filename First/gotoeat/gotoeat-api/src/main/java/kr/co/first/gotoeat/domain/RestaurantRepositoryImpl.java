package kr.co.first.gotoeat.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository
{
    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepositoryImpl()
    {
        restaurants.add(new Restaurant(1004, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020, "Cyber Food", "Seoul"));
    }

    @Override
    public List<Restaurant> findAll()
    {
        return restaurants;
    }

    @Override
    public Restaurant findById(int id)
    {
        return restaurants.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Restaurant save(Restaurant restaurant)
    {
        restaurant.setId(1234);
        restaurants.add(restaurant);
        return restaurant;
    }
}
