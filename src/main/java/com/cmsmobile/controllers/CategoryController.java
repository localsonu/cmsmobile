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

import com.cmsmobile.model.Category;
import com.cmsmobile.services.CategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.POST, value = "/category/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return new ResponseEntity<Category>(category, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/get/by/id/{categoryId}")
    public void getCategoryById(@PathVariable Long categoryId) {
        categoryService.getCategoryById(categoryId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/get/by/name/{categoryName}")
    public void getCategoryByName(@PathVariable String categoryName) {
        categoryService.getAllCategoriesByName(categoryName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all/category")
    public ResponseEntity<List<Category>> getCategories() {
       // httpHeaders.setConnection(categoryService.getAllCategories().toString());
        return new ResponseEntity<List<Category>>(categoryService.getAllCategories(), HttpStatus.OK);

    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/category/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
