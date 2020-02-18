package kr.co.first.gotoeat.interfaces;

import kr.co.first.gotoeat.application.RestaurantService;
import kr.co.first.gotoeat.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
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
    public Restaurant detail(@PathVariable("id") long id)
    {
        Restaurant restaurant = restaurantService.getRestaurant(id);

        return restaurant;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@Valid @RequestBody Restaurant resource) throws URISyntaxException
    {

        Restaurant restaurant = restaurantService.addRestaurant(
                Restaurant.builder()
                        .name(resource.getName())
                        .location(resource.getLocation())
                        .build());


        URI location = new URI("/restaurants/" + restaurant.getId());
        return ResponseEntity.created(location).body("{}");
    }

    @PatchMapping("/restaurants/{id}")
    public String update(@PathVariable("id") long id,
                         @Valid @RequestBody Restaurant resource)
    {
        String name = resource.getName();
        String location = resource.getLocation();
        restaurantService.updateRestaurant(id, name, location);
        return "{}";
    }
}
