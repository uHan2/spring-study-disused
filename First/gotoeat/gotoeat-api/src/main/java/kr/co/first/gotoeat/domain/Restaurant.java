package kr.co.first.gotoeat.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant
{
    private final String name;
    private final String location;
    private final int id;
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public Restaurant(int id, String name, String location)
    {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId()
    {

        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getLocation()
    {
        return location;
    }

    public String getInformation()
    {
        return name + " in " + location;
    }

    public List<MenuItem> getMenuItems()
    {
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem)
    {
        menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems)
    {
        for(MenuItem menuItem : menuItems)
        {
            addMenuItem(menuItem);
        }
    }
}
