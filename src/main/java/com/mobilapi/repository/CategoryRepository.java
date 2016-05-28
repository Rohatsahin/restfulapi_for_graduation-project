package com.mobilapi.repository;

import com.mobilapi.domain.category.Category;
import com.mobilapi.domain.shop.Restaurant;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository extends GenericRepository<Category> {

    public CategoryRepository() {
        super(Category.class);
    }

    public List<Category> getAllCategoryByRestaurant(ObjectId restaurant_id) {

        Query<Category> query = getDatastore().find(Category.class).disableValidation()
                .field("restaurant").equal(new Key(Restaurant.class,"restaurant",restaurant_id));

        return query.asList();
    }


}
