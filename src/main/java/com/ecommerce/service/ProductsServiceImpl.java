package com.ecommerce.service;

import com.ecommerce.dto.ProductResponse;
import com.ecommerce.entity.Products;
import com.ecommerce.exception.ProductException;
import com.ecommerce.repository.ProductsRepository;
import com.ecommerce.util.ProductDtoConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    private ProductsRepository productsRepository;
    @Autowired
    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<ProductResponse> findAll() {
        List<Products> products = productsRepository.findAll();
        return ProductDtoConversion.convertProductList(products);
    }

    @Override
    public ProductResponse findById(Long id) {
        Optional<Products> productsOptional = productsRepository.findById(id);
        if(productsOptional.isPresent()){
            Products products = productsOptional.get();
            return ProductDtoConversion.convertProduct(products);
        }
        throw new ProductException("Product with given id is not exist. " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public ProductResponse add(Products products) {
        Products product = productsRepository.save(products);
        return ProductDtoConversion.convertProduct(product);
    }

    @Override
    public ProductResponse remove(Long id) {
        ProductResponse products = findById(id);
        productsRepository.deleteById(id);
        return products;
    }
}
