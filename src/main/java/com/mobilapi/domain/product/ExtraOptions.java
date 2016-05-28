package com.mobilapi.domain.product;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class ExtraOptions {

    private String name;

    private Double value;

    private Boolean selected = Boolean.FALSE;

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

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
