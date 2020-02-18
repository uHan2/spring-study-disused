package kr.co.first.gotoeat.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
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
    private long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String location;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MenuItem> menuItems;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Review> reviews;

    public String getInformation()
    {
        return name + " in " + location;
    }

    public void setMenuItems(List<MenuItem> menuItems)
    {
        this.menuItems = new ArrayList<>(menuItems);
    }

    public void setReviews(List<Review> reviews)
    {
        this.reviews = new ArrayList<>(reviews);
    }

    public void updateInformation(String name, String location)
    {
        this.name = name;
        this.location = location;
    }
}
