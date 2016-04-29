package com.mobilapi.service;


import com.mobilapi.domain.product.Menu;
import com.mobilapi.domain.shop.Restaurant;
import com.mobilapi.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;


    public List<Menu> getMenuByRestaurant(Restaurant restaurant) {

        return menuRepository.findAllByRestaurant(restaurant);
    }


}
