package com.mobilapi.domain.order;


import com.mobilapi.domain.customer.AbstractAuditableEntity;
import com.mobilapi.domain.customer.Account;
import com.mobilapi.domain.product.Product;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.mongodb.morphia.annotations.Entity;

@Entity(value = "order" ,noClassnameStored = false)
public class Order extends AbstractAuditableEntity {

    @Reference
    private Account account;

    @Reference
    private Product product;



}
