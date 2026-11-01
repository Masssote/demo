package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.Category;
import com.example.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);

    @Query(value = "SELECT * FROM product p WHERE p.price < :maxPrice", nativeQuery = true)
    List<Product> findByProducsBelowMaxPrice(@Param("maxPrice") double maxPrice);
}
