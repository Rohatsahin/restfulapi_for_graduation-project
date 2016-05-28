package com.mobilapi.domain.shop;


import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class OpenHours {

    private String day;

    private String openAt;

    private String closeAt;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOpenAt() {
        return openAt;
    }

    public void setOpenAt(String openAt) {
        this.openAt = openAt;
    }

    public String getCloseAt() {
        return closeAt;
    }

    public void setCloseAt(String closeAt) {
        this.closeAt = closeAt;
    }
}
