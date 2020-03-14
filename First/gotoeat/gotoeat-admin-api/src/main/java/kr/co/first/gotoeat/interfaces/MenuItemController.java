package kr.co.first.gotoeat.interfaces;

import kr.co.first.gotoeat.application.MenuItemService;
import kr.co.first.gotoeat.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuItemController
{
    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/restaurants/{restaurantId}/menuitems")
    public List<MenuItem> list(@PathVariable("restaurantId") long restaurantId)
    {
        List<MenuItem> menuItems = menuItemService.getMenuItems(restaurantId);

        return menuItems;
    }



    @PatchMapping("/restaurants/{restaurantId}/menuitems")
    public String bulkUpdate(
            @PathVariable("restaurantId") long restaurantId,
            @RequestBody List<MenuItem> menuItems)
    {
        menuItemService.bulkUpdate(restaurantId, menuItems);

        return " ";
    }
}
