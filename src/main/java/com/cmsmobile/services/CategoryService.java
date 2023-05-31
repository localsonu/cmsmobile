package com.cmsmobile.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cmsmobile.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmsmobile.model.Category;
import com.cmsmobile.repositories.CategoryRepository;
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(Category category) {
        List<Category> catDb= categoryRepository.findByCategoryName(category.getCategoryName());
       if(catDb.size() >0 )
        throw new ProductNotFoundException();
       else
       return categoryRepository.save(category);

    }
    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        categoryRepository.findAll().forEach(categoryList::add);
        return categoryList;
    }

    public List<Category> getAllCategoriesByName(String categoryName) {
        List<Category> categoryList = new ArrayList<>();
        categoryList = categoryRepository.findByCategoryName(categoryName);
        return categoryList;
    }

    public Optional<Category> getCategoryById(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        return category;
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
    
}
