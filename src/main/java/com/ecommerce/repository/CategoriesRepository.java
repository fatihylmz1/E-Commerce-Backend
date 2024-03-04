package com.ecommerce.repository;

import com.ecommerce.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories,Long> {
}
