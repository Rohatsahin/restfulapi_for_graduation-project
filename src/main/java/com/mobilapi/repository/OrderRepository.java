package com.mobilapi.repository;


import com.mobilapi.domain.order.Order;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository extends GenericRepository<Order> {

    public OrderRepository() {
        super(Order.class);
    }

    public List<Order> getAllOrderByAccountId(String account_id) {
        Query<Order> query = getDatastore().find(Order.class)
                .field("account._id").equal(account_id);
        return query.asList();
    }

    public List<Order> getAllOrder(){
        return getDatastore().find(Order.class).asList();
    }
}
