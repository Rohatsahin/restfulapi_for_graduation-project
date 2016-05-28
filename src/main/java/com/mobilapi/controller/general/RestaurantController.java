package com.mobilapi.controller.general;

import com.mobilapi.service.RestaurantService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController extends BaseController {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(method = RequestMethod.GET, value = "/restaurants")
    @ResponseBody
    public ResponseEntity getAllRestaurant() {

        return new ResponseEntity(restaurantService.getAllRestaurant(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/restaurants/{restaurant_id}")
    @ResponseBody
    public ResponseEntity getAllRestaurantInfo(@PathVariable("restaurant_id") ObjectId restaurant_id) {

        return new ResponseEntity(restaurantService.getRestaurantByObjectId(restaurant_id),HttpStatus.OK);
    }




}
