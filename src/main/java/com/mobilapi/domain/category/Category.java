package com.mobilapi.domain.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mobilapi.domain.customer.AbstractAuditableEntity;
import com.mobilapi.domain.shop.Restaurant;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;


@Entity(value = "category", noClassnameStored = false)
public class Category extends AbstractAuditableEntity {

    private String thumb;

    private String title;

    private String desc;

    private Boolean featured;

    private String icon;

    @Reference
    private Restaurant restaurant;

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    @JsonIgnore
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
