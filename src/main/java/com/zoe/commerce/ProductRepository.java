package com.zoe.commerce;

import com.zoe.commerce.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
    Product findById(long id);
}
