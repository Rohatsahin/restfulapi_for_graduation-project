package com.mobilapi.service;


import com.mobilapi.domain.category.Category;
import com.mobilapi.domain.shop.Restaurant;
import com.mobilapi.repository.RestaurantRepository;
import com.mobilapi.service.util.CalculateCurrentScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getRestaurantByLocalize(String city, String district) {

        List<Restaurant> restaurants = getRestaurantByLocation(city, district);

        return  restaurants;
    }

    public List<Category> getRestaurantCategory(Long id) {

        return restaurantRepository.findById(id).getCategories();
    }

    public Restaurant getRestaurantById(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id);
        long score = CalculateCurrentScore.Calculate(restaurant.getScore());
        restaurant.setCurrentScore(score);

        return restaurant;
    }

    public Iterable<Restaurant> getAllRestaurant() {

        return restaurantRepository.findAll();
    }

    private List<Restaurant> getRestaurantByLocation(String city, String district) {
        return restaurantRepository.findByCityAndDistrict(city, district);
    }


}
