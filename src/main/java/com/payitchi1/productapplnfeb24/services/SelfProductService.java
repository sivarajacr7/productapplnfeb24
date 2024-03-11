package com.payitchi1.productapplnfeb24.services;

import com.payitchi1.productapplnfeb24.exceptions.ProductNotFoundException;
import com.payitchi1.productapplnfeb24.models.Category;
import com.payitchi1.productapplnfeb24.models.Product;
import com.payitchi1.productapplnfeb24.repositories.CategoryRepository;
import com.payitchi1.productapplnfeb24.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(long productId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getProduct() {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, String image, double price, String category) {
        Product product = new Product();
        product.setDescription(description);
        product.setTitle(title);
        product.setImageUrl(image);
        product.setPrice(price);
        Category categoryFromDb = categoryRepository.findByTitle(category);
        if(categoryFromDb==null)
        {
            categoryFromDb = new Category();
            categoryFromDb.setTitle(category);
        }
        product.setCategory(categoryFromDb);
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    @Override
    public List<Product> getAllProductCategory(String title) {
        return null;
    }

    @Override
    public List<Product> getAllTheProductCategories() {
        return null;
    }

    @Override
    public Product deleteSingleProduct(long productId) {
        return null;
    }

    @Override
    public Product updateSingleProduct(long productId) {
        return null;
    }
}
