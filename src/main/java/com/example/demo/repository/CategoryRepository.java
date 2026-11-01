package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String categoryName);

    @Query(value = "SELECT * FROM category c WHERE c.name = :categoryName", nativeQuery = true)
    Category findCategorByNameSQL(@Param("categoryName") String categoryName);
}
