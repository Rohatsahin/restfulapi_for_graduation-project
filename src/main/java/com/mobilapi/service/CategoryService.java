package com.mobilapi.service;

import com.mobilapi.domain.category.Category;
import com.mobilapi.repository.CategoryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategoryByRestaurantId(ObjectId restaurant_id){
        return categoryRepository.getAllCategoryByRestaurant(restaurant_id);
    }

    public Category getCategoryById(ObjectId category_id){
        return categoryRepository.findByObjectId(category_id);
    }
}
