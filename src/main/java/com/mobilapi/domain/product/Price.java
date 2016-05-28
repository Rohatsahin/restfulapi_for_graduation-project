package com.mobilapi.domain.product;

import com.mobilapi.domain.enums.Currency;
import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Price {

    private String name;

    private Double value;

    private Currency currency = Currency.TL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
