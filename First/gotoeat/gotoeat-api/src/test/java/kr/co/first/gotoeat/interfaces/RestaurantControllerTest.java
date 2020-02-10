package kr.co.first.gotoeat.interfaces;

import kr.co.first.gotoeat.application.RestaurantService;
import kr.co.first.gotoeat.domain.MenuItem;
import kr.co.first.gotoeat.domain.Restaurant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest
{
    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestaurantService restaurantService;


    @Test
    public void list() throws Exception
    {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(Restaurant.builder()
                .id(1004)
                .name("JOKER House")
                .location("Seoul")
                .build());

        given(restaurantService.getRestaurants()).willReturn(restaurants);

        mvc.perform(get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"JOKER House\"")));
    }

    @Test
    public void detail() throws Exception
    {
        Restaurant restaurant1 = Restaurant.builder()
                .id(1004)
                .name("JOKER House")
                .location("Seoul")
                .build();

        MenuItem menuItem = MenuItem.builder()
                .name("Kimchi")
                .build();

        restaurant1.setMenuItems(Arrays.asList(menuItem));

        Restaurant restaurant2 = Restaurant.builder()
                .id(2020)
                .name("Cyber Food")
                .location("Seoul")
                .build();


        given(restaurantService.getRestaurant(1004)).willReturn(restaurant1);
        given(restaurantService.getRestaurant(2020)).willReturn(restaurant2);

        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"JOKER House\"")))
                .andExpect(content().string(containsString("Kimchi")));

        mvc.perform(get("/restaurants/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":2020")))
                .andExpect(content().string(containsString("\"name\":\"Cyber Food\"")));
    }

    @Test
    public void create() throws Exception
    {
        given(restaurantService.addRestaurant(any())).will(invocation ->
        {
            Restaurant restaurant = invocation.getArgument(0);
            return Restaurant.builder()
                    .id(1004)
                    .name(restaurant.getName())
                    .location(restaurant.getLocation())
                    .build();
        });

        mvc.perform(post("/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"BeRyong\", \"address\":\"Busan\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/restaurants/1004"))
                .andExpect(content().string("{}"));

        verify(restaurantService).addRestaurant(any());
    }

    @Test
    public void update() throws Exception
    {

        mvc.perform(patch("/restaurants/1004")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"JOKER Bar\", \"location\":\"Busan\"}"))
                .andExpect(status().isOk());

        verify(restaurantService).updateRestaurant(1004, "JOKER Bar", "Busan");
    }
}