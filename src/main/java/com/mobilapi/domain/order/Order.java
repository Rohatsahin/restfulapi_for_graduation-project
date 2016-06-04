package com.mobilapi.domain.order;

import com.mobilapi.domain.customer.AbstractAuditableEntity;
import com.mobilapi.domain.customer.Account;
import com.mobilapi.domain.customer.Address;
import com.mobilapi.domain.product.Product;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

@Entity(value = "order" ,noClassnameStored = false)
public class Order extends AbstractAuditableEntity {

    @Reference
    private Account account;

    @Reference
    private Product product;

    @Embedded
    private Address address;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
