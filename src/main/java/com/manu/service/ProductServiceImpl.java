package com.manu.service;
import com.manu.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService { // Implements updated interface
    private final com.manu.repo.ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(com.manu.repo.ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        // Get the Iterable from CrudRepository's findAll()
        Iterable<Product> productsIterable = productRepository.findAll();

        // Convert the Iterable to a List using streams
        return StreamSupport.stream(productsIterable.spliterator(), false)
                            .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Integer s_no) { // <-- ID type is Integer
        return productRepository.findById(s_no);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Integer s_no) { // <-- ID type is Integer
        productRepository.deleteById(s_no);
    }
}