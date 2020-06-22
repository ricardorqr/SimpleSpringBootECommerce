package com.simpleSpringBootECommerce.repository;

import com.simpleSpringBootECommerce.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long> {

//    @Query(value = " select distinct(p) from Product p join fetch p.prices where p.id = :id ", nativeQuery = false)
//    Product getProduct(@Param("id") Long id);

}
