package com.mobilapi.domain.shop;


import org.mongodb.morphia.annotations.Embedded;

import java.util.ArrayList;
import java.util.List;

@Embedded
public class Map {

    private Long latitude;

    private Long longitude;

    private Integer zoomLevel;

    private List<Annotations> annotations = new ArrayList<>();

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Integer getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLevel(Integer zoomLevel) {
        this.zoomLevel = zoomLevel;
    }

    public List<Annotations> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotations> annotations) {
        this.annotations = annotations;
    }
}
