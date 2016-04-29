package com.mobilapi.controller.general;


import com.mobilapi.domain.shop.Restaurant;
import com.mobilapi.service.MenuService;
import com.mobilapi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/public")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RestaurantService restaurantService;


    @RequestMapping(value = "/restaurant_menu", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getRestaurantMenu(@RequestParam(value = "restaurant_id") String restaurant_id) {

        Restaurant restaurant = restaurantService.getRestaurantById(Long.valueOf(restaurant_id));

        if (restaurant == null) {
            return new ResponseEntity(HttpStatus.FAILED_DEPENDENCY);
        } else {
            return new ResponseEntity(menuService.getMenuByRestaurant(restaurant), HttpStatus.OK);
        }
    }

}
