package com.mobilapi.domain.features;


import com.mobilapi.domain.customer.AbstractAuditableEntity;
import com.mobilapi.domain.product.Product;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.mongodb.morphia.annotations.Entity;

@Entity(value = "features", noClassnameStored = false)
public class Features extends AbstractAuditableEntity {

    @Reference
    private Product product;
}
