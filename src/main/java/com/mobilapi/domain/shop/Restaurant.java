package com.mobilapi.domain.shop;


import com.mobilapi.domain.product.Menu;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Restaurant {

    @Id
    @Column(name = "restaurant_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String presentationTime;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String mersis;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "restaurant")
    private Score score;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "restaurant")
    private Menu menu;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "restaurant_payments", joinColumns =
            {@JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")}
            , inverseJoinColumns = {@JoinColumn(name = "payment_id", referencedColumnName = "id")})
    private Set<Payment> payments;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "restaurant_promotion", joinColumns = {@JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")}
            , inverseJoinColumns = {@JoinColumn(name = "promotion_id", referencedColumnName = "id")})
    private Set<Promotion> promotions;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "restaurant_service_locations", joinColumns = {@JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")}
            , inverseJoinColumns = {@JoinColumn(name = "service_location_id", referencedColumnName = "id")})
    private Set<ServiceLocations> serviceLocationses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresentationTime() {
        return presentationTime;
    }

    public void setPresentationTime(String presentationTime) {
        this.presentationTime = presentationTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getMersis() {
        return mersis;
    }

    public void setMersis(String mersis) {
        this.mersis = mersis;
    }

    public Set<ServiceLocations> getServiceLocationses() {
        return serviceLocationses;
    }

    public void setServiceLocationses(Set<ServiceLocations> serviceLocationses) {
        this.serviceLocationses = serviceLocationses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;

        Restaurant that = (Restaurant) o;

        if (!getId().equals(that.getId())) return false;
        return getName().equals(that.getName());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }
}
