package com.payitchi1.productapplnfeb24.repositories;

import com.payitchi1.productapplnfeb24.models.Category;
import com.payitchi1.productapplnfeb24.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category save(Category c);
    Category findByTitle(String title);
    List<Category> findAll();


}
