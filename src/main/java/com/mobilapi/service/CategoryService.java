package com.mobilapi.service;


import com.mobilapi.domain.category.Category;
import com.mobilapi.domain.product.Product;
import com.mobilapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> getAllCategory() {

        return categoryRepository.findAll();
    }

    public Set<Product> getAllProductByCategory(String category_guid) {

        Category category = categoryRepository.findByGuid(category_guid);

        if (category == null) {
            return null;
        } else {
            return category.getProducts();
        }
    }
}
