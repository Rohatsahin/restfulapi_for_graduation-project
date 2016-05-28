package com.mobilapi.repository;


import com.mobilapi.domain.shop.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantRepository extends GenericRepository<Restaurant> {

    public RestaurantRepository() {
        super(Restaurant.class);
    }

    public List<Restaurant> getAllRestaurant(){

        return getDatastore().find(Restaurant.class).asList();
    }

}
