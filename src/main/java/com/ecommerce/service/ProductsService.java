package com.ecommerce.service;

import com.ecommerce.dto.ProductResponse;
import com.ecommerce.entity.Products;

import java.util.List;

public interface ProductsService{
    List<ProductResponse> findAll();
    ProductResponse findById(Long id);
    ProductResponse add(Products products);
    ProductResponse remove(Long id);
}
