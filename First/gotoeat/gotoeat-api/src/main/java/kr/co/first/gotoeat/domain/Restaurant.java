package kr.co.first.gotoeat.domain;

public class Restaurant
{
    private final String name;
    private final String location;

    public Restaurant(String name, String location)
    {
        this.name = name;
        this.location = location;
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
