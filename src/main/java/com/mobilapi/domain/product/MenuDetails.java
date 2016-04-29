package com.mobilapi.domain.product;


import javax.persistence.*;
import java.util.Set;

@Entity
public class MenuDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String explanation;

    private Long price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinTable(name = "menu_details_extra", joinColumns = {@JoinColumn(name = "menu_detail_id", referencedColumnName = "id")}
            , inverseJoinColumns = {@JoinColumn(name = "menu_details_list_id", referencedColumnName = "id")})
    private Set<MenuDetailsList> menuDetailsLists;

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Set<MenuDetailsList> getMenuDetailsLists() {
        return menuDetailsLists;
    }

    public void setMenuDetailsLists(Set<MenuDetailsList> menuDetailsLists) {
        this.menuDetailsLists = menuDetailsLists;
    }
}
