package com.mobilapi.service;

import com.mobilapi.domain.product.Product;
import com.mobilapi.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProductByCategory(final ObjectId category_id){
        return productRepository.getAllProductByCategoryId(category_id);
    }

    public Product getProduct(final ObjectId product_id){
        return productRepository.findByObjectId(product_id);
    }

}
