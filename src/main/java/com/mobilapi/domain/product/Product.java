package com.mobilapi.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mobilapi.domain.category.Category;
import com.mobilapi.domain.customer.AbstractAuditableEntity;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity(value = "product",noClassnameStored = false)
public class Product extends AbstractAuditableEntity {

    private String thumb;

    private String title;

    private String body;

    @Embedded
    private List<Price> price;

    @Embedded
    private List<StandardOptions> standardOptions;

    @Embedded
    private List<ExtraOptions> extraOptions;

    @Reference
    private Category category;

    private List<String> tags = new ArrayList<>();

    private List<String> pictures = new ArrayList<>();

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Price> getPrice() {
        return price;
    }

    public void setPrice(List<Price> price) {
        this.price = price;
    }

    public List<StandardOptions> getStandardOptions() {
        return standardOptions;
    }

    public void setStandardOptions(List<StandardOptions> standardOptions) {
        this.standardOptions = standardOptions;
    }

    public List<ExtraOptions> getExtraOptions() {
        return extraOptions;
    }

    public void setExtraOptions(List<ExtraOptions> extraOptions) {
        this.extraOptions = extraOptions;
    }

    @JsonIgnore
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
}
