package kr.co.first.gotoeat.application;

import kr.co.first.gotoeat.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestaurantService
{
    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository)
    {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getRestaurants()
    {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        return restaurants;
    }

    public Restaurant getRestaurant(long id)
    {
        Restaurant restaurant = restaurantRepository.findById(id).
                orElseThrow(() -> new RestaurantNotFoundException(id));

        return restaurant;
    }

    public Restaurant addRestaurant(Restaurant restaurant)
    {
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public Restaurant updateRestaurant(long id, String name, String lcoation)
    {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        restaurant.updateInformation(name, lcoation);

        return restaurant;
    }
}
