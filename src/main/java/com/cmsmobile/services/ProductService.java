package com.cmsmobile.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmsmobile.model.Product;
import com.cmsmobile.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    // public List<Product> getAllProductss() {
    //     List<Product> ProductList = new ArrayList<>();
    //     productRepository.findAll().forEach(ProductList::add);
    //     return ProductList;
    // }

    public List<Product> getAllProductsByName(String productName) {
        List<Product> productList = new ArrayList<>();
        productList = productRepository.findByProductName(productName);
        return productList;
    }

    public Product getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        return product;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductByCatId(Long categoryId) {
        return productRepository.findProductByCategory_id(categoryId);
    }
}