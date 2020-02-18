package kr.co.first.gotoeat.application;

import kr.co.first.gotoeat.domain.MenuItem;
import kr.co.first.gotoeat.domain.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService
{
    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository)
    {
        this.menuItemRepository = menuItemRepository;
    }

    public void bulkUpdate(long restaurantId, List<MenuItem> menuItems)
    {
        for (MenuItem menuItem : menuItems)
        {
            update(restaurantId, menuItem);
        }
    }

    void update(long restaurantId, MenuItem menuItem)
    {
        if (menuItem.isDestroy())
        {
            menuItemRepository.deleteById(menuItem.getId());
            return;
        }
        menuItem.setRestaurantId(restaurantId);
        menuItemRepository.save(menuItem);
    }
}
