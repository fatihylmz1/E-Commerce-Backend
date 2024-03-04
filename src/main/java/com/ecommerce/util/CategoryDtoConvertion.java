package com.ecommerce.util;

import com.ecommerce.dto.CategoryResponse;
import com.ecommerce.entity.Categories;

import java.util.ArrayList;
import java.util.List;

public class CategoryDtoConvertion {

    public static List<CategoryResponse> convertCategoryList (List<Categories> categories){
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        categories.stream().forEach(categories1 ->
                categoryResponses.add(new CategoryResponse(categories1.getTitle(),categories1.getImg(),
                        categories1.getRating(),categories1.getGender())));
        return categoryResponses;
    }

    public static CategoryResponse convertCategory(Categories categories){
        return new CategoryResponse(categories.getTitle(), categories.getImg(), categories.getRating(), categories.getGender());
    }
}
