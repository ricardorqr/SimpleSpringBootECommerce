package com.simpleSpringBootECommerce.repository;

import com.simpleSpringBootECommerce.model.Product;
import com.simpleSpringBootECommerce.model.Type;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

//    @Query(value = " select distinct(p) from Product p join fetch p.prices where p.id = :id ", nativeQuery = false)
//    Product getProduct(@Param("id") Long id);
//
//    @Query(value = " select p.priceTypes from Product p ", nativeQuery = false)
//    List<Type> getAllProductType();

}
