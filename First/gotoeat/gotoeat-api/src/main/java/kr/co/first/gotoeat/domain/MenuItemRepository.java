package kr.co.first.gotoeat.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MenuItemRepository extends CrudRepository<MenuItem, Integer>
{
    List<MenuItem> findAllByRestaurantId(long restaurantId);
}
