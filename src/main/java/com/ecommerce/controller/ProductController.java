package com.ecommerce.controller;

import com.ecommerce.dto.ProductResponse;
import com.ecommerce.entity.Products;
import com.ecommerce.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ecommerce")
@CrossOrigin("*")
public class ProductController {

    private ProductsService productsService;

    @Autowired
    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/product")
    public List<ProductResponse> showAll(){
        return productsService.findAll();
    }

    @PostMapping("/product")
    public ProductResponse addProduct(@RequestBody Products products){
        return productsService.add(products);
    }
}
