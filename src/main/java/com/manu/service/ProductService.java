package com.manu.service;



import com.manu.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
	  List<Product> findAll();
	    Optional<Product> findById(Integer s_no);
	    Product save(Product product);
	    void deleteById(Integer s_no);
}
