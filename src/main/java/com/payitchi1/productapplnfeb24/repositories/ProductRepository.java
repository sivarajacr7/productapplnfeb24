package com.payitchi1.productapplnfeb24.repositories;

import com.payitchi1.productapplnfeb24.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product p);

}
