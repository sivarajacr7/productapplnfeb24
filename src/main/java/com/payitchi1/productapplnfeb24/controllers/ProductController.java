package com.payitchi1.productapplnfeb24.controllers;

import com.payitchi1.productapplnfeb24.dtos.CreateProductRequestDto;
import com.payitchi1.productapplnfeb24.models.Category;
import com.payitchi1.productapplnfeb24.models.Product;
import com.payitchi1.productapplnfeb24.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    private RestTemplate restTemplate;
    public ProductController(ProductService productService,RestTemplate restTemplate)
    {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") long productId)
    {
    return productService.getSingleProduct(productId);
    }
    @GetMapping("/products/")
    public List<Product> getProduct()
    {
    return productService.getProduct();
    }
    @PostMapping("/products/")
    public Product createProduct(@RequestBody CreateProductRequestDto request)
    {
        return productService.createProduct(request.getTitle(), request.getDescription(),
                request.getImage(), request.getPrice(), request.getCategory());
    }
    @GetMapping("/products/category/{categoryName}")
    public List<Product> getProductCategory(@PathVariable("categoryName")String categoryTitle)
    {
        return productService.getAllProductCategory(categoryTitle);
    }
    @GetMapping("/products/categories/")
    public List<Product> getAllProductCategories()
    {
        return productService.getAllTheProductCategories();
    }
    @DeleteMapping("/products/{deleteproduct}")
    public Product deleteProduct(@PathVariable("deleteproduct") long productId)
    {
        return productService.deleteSingleProduct(productId);
    }
    @PutMapping("/products/{updateproduct}")
    public Product updateProduct(@PathVariable("updateproduct") long productId)
    {
        return productService.updateSingleProduct(productId);
    }
}
