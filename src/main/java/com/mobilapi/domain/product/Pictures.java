package com.mobilapi.domain.product;

import javax.persistence.*;

@Embeddable
public class Pictures {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
