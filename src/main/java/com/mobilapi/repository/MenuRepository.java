package com.mobilapi.repository;

import com.mobilapi.domain.product.Menu;
import com.mobilapi.domain.shop.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends CrudRepository<Menu,Long> {

    List<Menu> findAllByRestaurant(Restaurant restaurant);
}
