package com.mobilapi.domain.product;

import com.mobilapi.domain.shop.Restaurant;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Menu {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "menu_items" ,joinColumns = {@JoinColumn(name = "menu_id",referencedColumnName = "menu_id")},
            inverseJoinColumns ={@JoinColumn(name = "menu_details",referencedColumnName = "id")} )
    private Set<MenuDetails> menuDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<MenuDetails> getMenuDetails() {
        return menuDetails;
    }

    public void setMenuDetails(Set<MenuDetails> menuDetails) {
        this.menuDetails = menuDetails;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


}
