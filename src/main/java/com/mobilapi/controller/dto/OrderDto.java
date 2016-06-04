package com.mobilapi.controller.dto;

import com.mobilapi.domain.customer.Address;

public class OrderDto {

    private String product_id;

    private Address address;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
