package com.cmsmobile.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmsmobile.model.Product;
import com.cmsmobile.services.ProductService;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST, value = "/product/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/product/get/by/id/{productId}")
    public void getProductById(@PathVariable Long productId) {
        productService.getProductById(productId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/product/get/by/name/{productName}")
    public void getProductByName(@PathVariable String productName) {
        productService.getAllProductsByName(productName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all/product")
    public List<Product> getProducts() {
        return productService.getAllProducts();

    }
    
}
