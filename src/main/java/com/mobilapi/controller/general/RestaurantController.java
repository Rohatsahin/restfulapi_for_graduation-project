package com.mobilapi.controller.general;

import com.mobilapi.domain.customer.Account;
import com.mobilapi.service.OrderService;
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

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET, value = "/restaurants")
    @ResponseBody
    public ResponseEntity getAllRestaurant() {

        return new ResponseEntity(restaurantService.getAllRestaurant(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/restaurant/{restaurant_id}")
    @ResponseBody
    public ResponseEntity getAllRestaurantInfo(@PathVariable("restaurant_id") ObjectId restaurant_id) {

        return new ResponseEntity(restaurantService.getRestaurantByObjectId(restaurant_id),HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getAllOrder")
    @ResponseBody
    public ResponseEntity getAccountOrder() {

        return new ResponseEntity(orderService.getAllOrder(), HttpStatus.OK);
    }


}
