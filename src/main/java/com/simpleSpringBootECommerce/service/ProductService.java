package com.simpleSpringBootECommerce.service;

import com.simpleSpringBootECommerce.model.PriceType;
import com.simpleSpringBootECommerce.model.Product;
import com.simpleSpringBootECommerce.model.Type;
import com.simpleSpringBootECommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

//    public Product getProduct(Long id) {
//        return productRepository.getProduct(id);
//        return new Product();
//    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

//    public List<Type> getAllProductType() {
//        return productRepository.getAllProductType();
//    }

}
