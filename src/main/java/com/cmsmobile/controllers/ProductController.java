package com.cmsmobile.controllers;

import java.util.List;

import com.cmsmobile.exception.ProductNotFoundException;
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

    @RequestMapping(method = RequestMethod.POST, value = "/product/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/product/get/by/id/{productId}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProductById(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        if (product != null)
            return new ResponseEntity<>( product, HttpStatus.OK);
        else
        throw new ProductNotFoundException();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/product/get/by/name/{productName}")
    public void getProductByName(@PathVariable String productName) {
        productService.getAllProductsByName(productName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all/product")
    public List<Product> getProducts() {
        return productService.getAllProducts();

    }
    @RequestMapping(method = RequestMethod.GET, value = "/product/category/{catId}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProductByCategoryId(@PathVariable Long catId) {
        List<Product> product = productService.getProductByCatId(catId);
        if (product != null)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            throw new ProductNotFoundException();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/category/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }
}
