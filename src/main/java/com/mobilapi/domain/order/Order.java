package com.mobilapi.domain.order;

import com.mobilapi.domain.customer.Location;
import com.mobilapi.domain.customer.Account;
import com.mobilapi.domain.product.Menu;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Account_Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_menu",joinColumns = {@JoinColumn(name = "order_id",referencedColumnName = "id")}
    ,inverseJoinColumns = {@JoinColumn(name = "menu_id",referencedColumnName = "menu_id")})
    private List<Menu> menus;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Account account;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    private Long price;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Location location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Menu> getMenuDetailsList() {
        return menus;
    }

    public void setMenuDetailsList(List<Menu> menus) {
        this.menus = menus;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        return getId().equals(order.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
