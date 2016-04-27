package com.mobilapi.domain.product;

import com.mobilapi.domain.shop.Restaurant;

import javax.persistence.*;

@Entity
public class Menu {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "menu")
    private MenuDetails menuDetails;

    @OneToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MenuDetails getMenuDetails() {
        return menuDetails;
    }

    public void setMenuDetails(MenuDetails menuDetails) {
        this.menuDetails = menuDetails;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


}
