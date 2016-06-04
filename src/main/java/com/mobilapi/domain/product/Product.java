package com.mobilapi.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mobilapi.domain.category.Category;
import com.mobilapi.domain.customer.AbstractAuditableEntity;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

import java.util.ArrayList;

@Entity(value = "product", noClassnameStored = false)
public class Product extends AbstractAuditableEntity {

    private String thumb;

    private String title;

    private String body;

    @Embedded
    private ArrayList<Price> price;

    @Embedded
    private ArrayList<StandardOptions> standardOptions;

    @Embedded
    private ArrayList<ExtraOptions> extraOptions;

    @Reference()
    private Category category;

    private ArrayList<String> tags = new ArrayList<>();

    private ArrayList<String> pictures = new ArrayList<>();

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

    public ArrayList<Price> getPrice() {
        return price;
    }

    public void setPrice(ArrayList<Price> price) {
        this.price = price;
    }

    public ArrayList<StandardOptions> getStandardOptions() {
        return standardOptions;
    }

    public void setStandardOptions(ArrayList<StandardOptions> standardOptions) {
        this.standardOptions = standardOptions;
    }

    public ArrayList<ExtraOptions> getExtraOptions() {
        return extraOptions;
    }

    public void setExtraOptions(ArrayList<ExtraOptions> extraOptions) {
        this.extraOptions = extraOptions;
    }

    @JsonIgnore
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<String> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<String> pictures) {
        this.pictures = pictures;
    }
}
