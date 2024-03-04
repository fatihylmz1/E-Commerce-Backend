package com.ecommerce.util;

import com.ecommerce.dto.ProductResponse;
import com.ecommerce.entity.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductDtoConversion {
    public static List<ProductResponse> convertProductList (List<Products> products){
        List<ProductResponse> productResponses = new ArrayList<>();
        products.stream().forEach(products1 ->
                productResponses.add(new ProductResponse(products1.getName(),products1.getDescription(),
                        products1.getPrice(),products1.getRating(),products1.getImage())));
        return productResponses;
    }

    public static ProductResponse convertProduct(Products products){
        return new ProductResponse(products.getName(), products.getDescription(),
                products.getPrice(), products.getRating(), products.getImage());
    }
}
