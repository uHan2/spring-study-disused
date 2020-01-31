package kr.co.first.gotoeat.domain;

public class Restaurant
{
    private final String name;
    private final String location;
    private final int id;

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
}
