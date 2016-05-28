package com.mobilapi.repository;

import com.mobilapi.domain.category.Category;
import com.mobilapi.domain.product.Product;
import com.mobilapi.exception.AppExceptions;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository extends GenericRepository<Product> {

    public ProductRepository() {
        super(Product.class);
    }

    public List<Product> getAllProductByCategoryId(ObjectId category_id) {
        try {
            Query<Product> query = getDatastore().find(Product.class).disableValidation()
                    .field("category").equal(new Key(Category.class, "category", category_id));
            return query.asList();
        } catch (Exception e) {
            throw new AppExceptions("Message for getAllProductByCategoryId in ProductRepository : ", e);
        }
    }
}
