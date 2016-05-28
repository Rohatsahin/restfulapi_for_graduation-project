package com.mobilapi.service;

import com.mobilapi.domain.shop.Restaurant;
import com.mobilapi.repository.RestaurantRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.getAllRestaurant();
    }

    public Restaurant getRestaurantByObjectId(ObjectId restaurant_id){
        return  restaurantRepository.findByObjectId(restaurant_id);
    }

}
