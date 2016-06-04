package com.mobilapi.domain.shop;

import com.mobilapi.domain.customer.AbstractAuditableEntity;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity(value = "restaurant", noClassnameStored = false)
public class Restaurant extends AbstractAuditableEntity {

    private String storeName;

    private String address;

    private String desc;

    private String phoneNumber;

    private String email;

    private String thumb;

    @Embedded
    private List<OpenHours> openHours = new ArrayList<>();

    @Embedded
    private Map map;

    public Restaurant() {
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public List<OpenHours> getOpenHours() {
        return openHours;
    }

    public void setOpenHours(List<OpenHours> openHours) {
        this.openHours = openHours;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
