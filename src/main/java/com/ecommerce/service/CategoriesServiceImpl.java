package com.ecommerce.service;

import com.ecommerce.dto.CategoryResponse;
import com.ecommerce.entity.Categories;
import com.ecommerce.exception.CategoryException;
import com.ecommerce.repository.CategoriesRepository;
import com.ecommerce.util.CategoryDtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService{

    private CategoriesRepository categoriesRepository;
    @Autowired
    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public List<CategoryResponse> findAll() {
        List<Categories> categories = categoriesRepository.findAll();
        return CategoryDtoConvertion.convertCategoryList(categories);
    }

    @Override
    public CategoryResponse findById(Long id) {
        Optional<Categories> categoriesOptional = categoriesRepository.findById(id);
        if(categoriesOptional.isPresent()){
            Categories category = categoriesOptional.get();
        return CategoryDtoConvertion.convertCategory(category);
        }
        throw new CategoryException("Category with given id is not exist." + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public CategoryResponse add(Categories categories) {
        Categories category = categoriesRepository.save(categories);
        return CategoryDtoConvertion.convertCategory(category);
    }

    @Override
    public CategoryResponse delete(Long id) {
        CategoryResponse category = findById(id);
        categoriesRepository.deleteById(id);
        return category;
    }
}
