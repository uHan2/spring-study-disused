package kr.co.first.gotoeat.application;

import kr.co.first.gotoeat.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RestaurantServiceTest
{
    private RestaurantService restaurantService;
    private RestaurantRepository restaurantRepository;
    private MenuItemRepository menuItemRepository;

    @BeforeEach
    public void setUp()
    {
        restaurantRepository = new RestaurantRepositoryImpl();
        menuItemRepository = new MenuItemRepositoryImpl();
        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);

    }

    @Test
    public void getRestaurants()
    {
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        Restaurant restaurant = restaurants.get(0);
        assertThat(restaurant.getId(), is(1004));
    }

    @Test
    public void getRestaurant()
    {
        Restaurant restaurant = restaurantService.getRestaurant(1004);

        assertThat(restaurant.getId(), is(1004));

        MenuItem menuitem = restaurant.getMenuItems().get(0);

        assertThat(menuitem.getName(), is("Kimchi"));
    }


}