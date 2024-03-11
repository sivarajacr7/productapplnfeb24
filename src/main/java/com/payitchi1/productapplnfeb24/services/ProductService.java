package com.payitchi1.productapplnfeb24.services;

import com.payitchi1.productapplnfeb24.exceptions.ProductNotFoundException;
import com.payitchi1.productapplnfeb24.models.Category;
import com.payitchi1.productapplnfeb24.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(long productId) throws ProductNotFoundException;
    List<Product> getProduct();
    Product createProduct(String title,String description,
                          String image,double price,String category);
    List<Product> getAllProductCategory(String title);
    List<String> getAllCategories();
    Product deleteSingleProduct(long productId);
    Product updateSingleProduct(long productId,String title,String description,
                                String image,double price,String category);
}
