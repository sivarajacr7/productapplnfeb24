package com.payitchi1.productapplnfeb24.repositories;

import com.payitchi1.productapplnfeb24.models.Category;
import com.payitchi1.productapplnfeb24.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product p);
    Product findById(long id);
    List<Product> findAll();
    List<Product> findAllByCategoryEquals(Category c);
  //Product deleteById(long id);
  void deleteById(long id);
}