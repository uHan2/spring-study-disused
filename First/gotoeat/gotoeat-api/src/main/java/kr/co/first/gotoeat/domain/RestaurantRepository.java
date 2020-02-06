package kr.co.first.gotoeat.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>
{
    List<Restaurant> findAll();

    Optional<Restaurant> findById(int id);

    Restaurant save(Restaurant restaurant);
}
