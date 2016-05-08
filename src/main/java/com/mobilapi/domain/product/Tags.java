package com.mobilapi.domain.product;

import javax.persistence.Embeddable;

@Embeddable
public class Tags {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
