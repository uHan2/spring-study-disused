package kr.co.first.gotoeat.interfaces;

import kr.co.first.gotoeat.application.MenuItemService;
import kr.co.first.gotoeat.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuItemController
{
    @Autowired
    private MenuItemService menuItemService;

    @PatchMapping("/restaurants/{restaurantId}/menuitems")
    public String bulkUpdate(
            @PathVariable("restaurantId") long restaurantId,
            @RequestBody List<MenuItem> menuItems)
    {
        menuItemService.bulkUpdate(restaurantId, menuItems);

        return " ";
    }
}
