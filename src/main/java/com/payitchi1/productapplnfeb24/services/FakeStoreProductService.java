package com.payitchi1.productapplnfeb24.services;


import com.payitchi1.productapplnfeb24.dtos.FakeStoreProductDto;
import com.payitchi1.productapplnfeb24.exceptions.ProductNotFoundException;
import com.payitchi1.productapplnfeb24.models.Category;
import com.payitchi1.productapplnfeb24.models.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(long productId) throws ProductNotFoundException {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoresponse = restTemplate.getForEntity
                ("https://fakestoreapi.com/products/"+productId, FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProduct = fakeStoreProductDtoresponse.getBody();
        if(fakeStoreProduct == null)
        {
            throw new ProductNotFoundException("product with id"+productId +"doesnt exist");
        }
        return fakeStoreProduct.toProduct();
    }

    @Override
    public List<Product> getProduct() {

        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject
                ("https://fakestoreapi.com/products",FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        //throw new RuntimeException();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos)
        {
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }

    @Override
    public Product createProduct(String title,String description,
                                 String image,double price,String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);

        FakeStoreProductDto response = restTemplate.postForObject
                ("https://fakestoreapi.com/products", fakeStoreProductDto,
                        FakeStoreProductDto.class);
        return response.toProduct();

    }

    @Override
    public List<Product> getAllProductCategory(String categoryNames) {

        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject
                ("https://fakestoreapi.com/products/category/"+categoryNames, FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto :fakeStoreProductDtos)
        {
        products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }

    @Override
    public List<Product> getAllTheProductCategories() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject
                ("fakestoreapi.com/products/categories", FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto :fakeStoreProductDtos)
        {
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }

    @Override
    public Product deleteSingleProduct(long productId) {

        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject
                ("https://fakestoreapi.com/products/"+productId, FakeStoreProductDto.class);
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public Product updateSingleProduct(long productId) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject
                ("https://fakestoreapi.com/products/"+productId, FakeStoreProductDto.class);
        return fakeStoreProductDto.toProduct();
    }

}
