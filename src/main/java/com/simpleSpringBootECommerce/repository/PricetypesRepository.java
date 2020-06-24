package com.simpleSpringBootECommerce.repository;

import com.simpleSpringBootECommerce.model.Pricetype;
import com.simpleSpringBootECommerce.model.PricetypePK;
import com.simpleSpringBootECommerce.model.Type;
import org.springframework.data.repository.CrudRepository;

public interface PricetypesRepository extends CrudRepository<Pricetype, PricetypePK> {

}
