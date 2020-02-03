package kr.co.first.gotoeat.interfaces;

import kr.co.first.gotoeat.domain.Restaurant;
import kr.co.first.gotoeat.domain.RestaurantRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController
{
    @Autowired
    private RestaurantRepositoryImpl repository;

    @GetMapping("/restaurants")
    public List<Restaurant> list()
    {
//        List<Restaurant> restaurants = new ArrayList<>();
//
//        Restaurant restaurant = new Restaurant(1004, "Bob zip", "Seoul");

        List<Restaurant> restaurants = repository.findAll();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") int id)
    {
        Restaurant restaurant = repository.findById(id);

//        Restaurant restaurant = restaurants.stream()
//                .filter(r -> r.getId() == id)
//                .findFirst()
//                .orElse(null);

        return restaurant;
    }
}
