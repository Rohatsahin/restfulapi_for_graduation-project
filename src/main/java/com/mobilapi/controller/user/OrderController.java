package com.mobilapi.controller.user;


import com.mobilapi.controller.dto.OrderDto;
import com.mobilapi.domain.customer.Account;
import com.mobilapi.domain.customer.Address;
import com.mobilapi.domain.order.Order;
import com.mobilapi.domain.product.Product;
import com.mobilapi.security.service.AuthenticationService;
import com.mobilapi.service.OrderService;
import com.mobilapi.service.ProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController extends SecureBaseController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST, value = "/createOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity saveNewOrder(@RequestBody OrderDto orderDto) {

        Order order = new Order();

        Account account = authenticationService.getCurrentAccount();
        Product product = productService.getProduct(new ObjectId(orderDto.getProduct_id()));

        order.setAccount(account);
        order.setProduct(product);

        if (orderDto.getAddress() instanceof Address) {
            order.setAddress(orderDto.getAddress());
        }

        return new ResponseEntity(orderService.createOrder(order), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/getCurrentAccountOrder")
    @ResponseBody
    public ResponseEntity getAccountOrder() {

        Account account = authenticationService.getCurrentAccount();

        return new ResponseEntity(orderService.getOrderByAccountId(account.getId()), HttpStatus.OK);
    }


}

