package com.cmsmobile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmsmobile.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
   List<Category> findByCategoryName(String categoryName);
   Category findCategoryByCategoryName(String categoryName);

}
