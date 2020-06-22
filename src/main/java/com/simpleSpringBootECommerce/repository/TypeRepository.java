package com.simpleSpringBootECommerce.repository;

import com.simpleSpringBootECommerce.model.Product;
import com.simpleSpringBootECommerce.model.Type;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeRepository extends CrudRepository<Type, Long> {

}
