package com.libreria.martha.service;

import com.libreria.martha.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getProductsByName(String name);
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product saveProduct(Product product);
    Product updateProduct(Long id, Product updatedProduct);
    void deleteProduct(Long id);

}