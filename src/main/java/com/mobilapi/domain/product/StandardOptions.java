package com.mobilapi.domain.product;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class StandardOptions {

    private String name;

    private Boolean selected = Boolean.FALSE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
