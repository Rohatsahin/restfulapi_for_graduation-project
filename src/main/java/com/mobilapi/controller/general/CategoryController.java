package com.mobilapi.controller.general;

import com.mobilapi.domain.product.ExtraOptions;
import com.mobilapi.domain.product.Product;
import com.mobilapi.repository.ProductRepository;
import com.mobilapi.service.CategoryService;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController extends BaseController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/categories/{restaurant_id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAllRestaurantCategory(@PathVariable("restaurant_id") ObjectId restaurant_id) {

        return new ResponseEntity(categoryService.getAllCategoryByRestaurantId(restaurant_id), HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{category_id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getCategoryInfo(@PathVariable("category_id") ObjectId category_id) {

        return new ResponseEntity(categoryService.getCategoryById(category_id), HttpStatus.OK);
    }

}
