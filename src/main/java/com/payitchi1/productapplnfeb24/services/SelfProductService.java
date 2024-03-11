package com.payitchi1.productapplnfeb24.services;

import com.payitchi1.productapplnfeb24.exceptions.ProductNotFoundException;
import com.payitchi1.productapplnfeb24.models.Category;
import com.payitchi1.productapplnfeb24.models.Product;
import com.payitchi1.productapplnfeb24.repositories.CategoryRepository;
import com.payitchi1.productapplnfeb24.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Product p = productRepository.findById(productId);
        return p;
    }

    @Override
    public List<Product> getProduct() {
        List<Product> p = productRepository.findAll();
        return p;
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
            Category newCategory = new Category();
            newCategory.setTitle(category);
            categoryFromDb = newCategory;
        }
        product.setCategory(categoryFromDb);
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    @Override
    public List<Product> getAllProductCategory(String title) {
        Category c = categoryRepository.findByTitle(title);
        List<Product> p = productRepository.findAllByCategoryEquals(c);
        return p;
    }

    @Override
    public List<String> getAllCategories() {
        List<Category> c = categoryRepository.findAll();
        List<String> allcateg = new ArrayList<>();
        for(Category c1:c)
        {
            allcateg.add(c1.getTitle());
        }
        return allcateg;
    }

    @Override
    public Product deleteSingleProduct(long productId) {

        Product p = productRepository.deleteById(productId);
        return p;
    }

    @Override
    public Product updateSingleProduct(long productId,String title,String description,
                                       String image,double price,String category) {
        Product product = productRepository.findById(productId);
        product.setDescription(description);
        product.setTitle(title);
        product.setImageUrl(image);
        product.setPrice(price);
        Category categoryFromDb = categoryRepository.findByTitle(category);
        if(categoryFromDb==null)
        {
            Category newCategory = new Category();
            newCategory.setTitle(category);
            categoryFromDb = newCategory;
        }
        product.setCategory(categoryFromDb);
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }
}
