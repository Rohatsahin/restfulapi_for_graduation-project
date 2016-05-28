package com.mobilapi.controller.general;

import com.mobilapi.service.ProductService;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController extends BaseController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products/{category_id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAllProductByCategoryId(@PathVariable("category_id") ObjectId category_id) {

        return new ResponseEntity(productService.getAllProductByCategory(category_id), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{product_id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getProductById(@PathVariable("product_id") ObjectId product_id) {

        return new ResponseEntity(productService.getProduct(product_id), HttpStatus.OK);
    }

}
