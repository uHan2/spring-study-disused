package kr.co.first.gotoeat.domain;

import java.util.List;


public interface MenuItemRepository
{
    List<MenuItem> findAllByRestaurantId(int restaurantId);
}
