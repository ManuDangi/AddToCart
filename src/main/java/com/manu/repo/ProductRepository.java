package com.manu.repo;

import com.manu.model.Product;
import org.springframework.data.repository.CrudRepository;  

public interface ProductRepository extends CrudRepository<Product, Integer> { 
    
}