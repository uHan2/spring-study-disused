package kr.co.first.gotoeat.domain;

public class RestaurantNotFoundException extends RuntimeException
{

    public RestaurantNotFoundException(long id)
    {
        super("Could Not Found Restaurant" + id);
    }
}
