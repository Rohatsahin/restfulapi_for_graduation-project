package com.mobilapi.service;


import com.mobilapi.domain.order.Order;
import com.mobilapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public String createOrder(Order order) {
        return orderRepository.persist(order);
    }

    public List<Order> getOrderByAccountId(String account_id) {
        return orderRepository.getAllOrderByAccountId(account_id);
    }

    public List<Order> getAllOrder(){

        return orderRepository.getAllOrder();
    }

}
