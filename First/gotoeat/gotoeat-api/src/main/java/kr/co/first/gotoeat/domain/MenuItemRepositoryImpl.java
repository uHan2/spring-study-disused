package kr.co.first.gotoeat.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuItemRepositoryImpl implements MenuItemRepository
{
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public MenuItemRepositoryImpl()
    {
        menuItems.add(new MenuItem("Kimchi"));
    }

    @Override
    public List<MenuItem> findAllByRestaurantId(int restaurantId)
    {
        return menuItems;
    }
}
