package com.mobilapi.service;

import com.mobilapi.domain.customer.Account;
import com.mobilapi.domain.order.Order;
import com.mobilapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrderByAccount(Account account){

        return orderRepository.findAllByAccount(account);
    }

}
