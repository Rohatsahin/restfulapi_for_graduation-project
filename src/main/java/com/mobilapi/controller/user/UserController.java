package com.mobilapi.controller.user;


import com.mobilapi.domain.customer.Account;
import com.mobilapi.domain.customer.Location;
import com.mobilapi.domain.order.Order;
import com.mobilapi.security.AuthenticationService;
import com.mobilapi.service.AccountService;
import com.mobilapi.service.LocationService;
import com.mobilapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/secure/getOrder", method = RequestMethod.GET)
    public List<Order> getCurrentAccountOrder() {

        Account account = accountService.findByEmail(authenticationService.getCurrentAccount().getEmail());
        List<Order> order = orderService.getAllOrderByAccount(account);

        return order;
    }

    @RequestMapping(value = "/secure/createOrder", method = RequestMethod.POST)
    @ResponseBody
    public void createLocationByAccount(@RequestBody Location location, Principal principal) {

        Account account = accountService.findByEmail(principal.getName());
        location.setAccount(account);

        locationService.createNewLocation(location);
    }

    @RequestMapping(value = "/secure/getLocations", method = RequestMethod.GET)
    public List<Location> getLocationsByAccount() {

        return locationService.getAllLocationByAccount();
    }


}
