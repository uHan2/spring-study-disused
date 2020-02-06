package kr.co.first.gotoeat.interfaces;

import kr.co.first.gotoeat.application.RestaurantService;
import kr.co.first.gotoeat.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController
{
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list()
    {
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") int id)
    {
        Restaurant restaurant = restaurantService.getRestaurant(id);
        
        return restaurant;
    }
}