package com.cmsmobile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cmsmobile.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductName(String productName);

    @Query(value ="select * from Product where category_id= ?1 " , nativeQuery = true)
    List<Product> findProductByCategory_id(Long categoryId);

}
