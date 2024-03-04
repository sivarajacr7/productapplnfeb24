package com.payitchi1.productapplnfeb24.dtos;

import com.payitchi1.productapplnfeb24.models.Category;
import com.payitchi1.productapplnfeb24.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private long id;
    private double price;
    private String title;
    private String description;
    private String image;
    private String category;

    public Product toProduct()
    {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);
        Category productCategory = new Category();
        productCategory.setTitle(category);
        product.setCategory(productCategory);
        return product;
    }
}
