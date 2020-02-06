package kr.co.first.gotoeat.domain;

import java.util.List;

public interface RestaurantRepository
{
    List<Restaurant> findAll();

    Restaurant findById(int id);

    Restaurant save(Restaurant restaurant);
}
