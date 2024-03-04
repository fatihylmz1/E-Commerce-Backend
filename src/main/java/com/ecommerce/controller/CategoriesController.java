package com.ecommerce.controller;

import com.ecommerce.dto.CategoryResponse;
import com.ecommerce.entity.Categories;
import com.ecommerce.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce")
@CrossOrigin("*")
public class CategoriesController {

    private CategoriesService categoriesService;
    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/categories")
    public List<CategoryResponse> showAll(){
        return categoriesService.findAll();
    }

    @DeleteMapping("/categories/{id}")
    public CategoryResponse delete(@PathVariable Long id){
        return categoriesService.delete(id);
    }

    @PostMapping("/categories")
    public CategoryResponse addCategory(@RequestBody Categories categories){
        return categoriesService.add(categories);
    }
}
