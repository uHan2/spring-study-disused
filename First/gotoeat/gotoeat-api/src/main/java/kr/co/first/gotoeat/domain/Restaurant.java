package kr.co.first.gotoeat.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant
{
    @Id
    @GeneratedValue
    @Setter
    private int id;

    private String name;
    private String location;

    @Transient
    private List<MenuItem> menuItems;

    public String getInformation()
    {
        return name + " in " + location;
    }

    public void setMenuItems(List<MenuItem> menuItems)
    {
        this.menuItems = new ArrayList<>(menuItems);
    }

    public void updateInformation(String name, String location)
    {
        this.name = name;
        this.location = location;
    }
}
