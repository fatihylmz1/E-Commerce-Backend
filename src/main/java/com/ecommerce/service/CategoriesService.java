package com.ecommerce.service;

import com.ecommerce.dto.CategoryResponse;
import com.ecommerce.entity.Categories;

import java.util.List;

public interface CategoriesService {

    List<CategoryResponse> findAll();
    CategoryResponse findById(Long id);
    CategoryResponse add(Categories categories);
    CategoryResponse delete(Long id);

}
