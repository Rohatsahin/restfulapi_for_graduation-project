package com.mobilapi.controller.general;


import com.mobilapi.domain.shop.Promotion;
import com.mobilapi.service.RestaurantService;
import com.mobilapi.service.dto.RestaurantListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/public")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(method = RequestMethod.GET, value = "/restaurants/{city}/{district}")
    public List<RestaurantListDto> showRestaurantByLocalize(@PathVariable("city") String city, @PathVariable("district") String district) {

        return restaurantService.getRestaurantByLocalize(city, district);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/promotions/{city}/{district}")
    public List<Promotion> getPromotionsByLocalize(@PathVariable("city") String city, @PathVariable("district") String district) {

        return restaurantService.getPromotionByLocalize(city, district);
    }


}
