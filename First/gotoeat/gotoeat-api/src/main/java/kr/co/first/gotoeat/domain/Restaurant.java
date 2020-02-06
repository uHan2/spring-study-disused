package kr.co.first.gotoeat.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant
{
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String location;

    @Transient
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public Restaurant(){};

    public Restaurant(String name, String location)
    {
        this.name = name;
        this.location = location;
    }

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

    public void setId(int id)
    {
        this.id = id;
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
