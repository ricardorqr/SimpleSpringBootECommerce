package com.simpleSpringBootECommerce.service;

import com.simpleSpringBootECommerce.model.Pricetype;
import com.simpleSpringBootECommerce.model.PricetypePK;
import com.simpleSpringBootECommerce.model.Product;
import com.simpleSpringBootECommerce.model.Type;
import com.simpleSpringBootECommerce.repository.PricetypesRepository;
import com.simpleSpringBootECommerce.repository.ProductRepository;
import com.simpleSpringBootECommerce.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private PricetypesRepository pricetypesRepository;

    public Product save(Product productAuxiliar) {
        List<Pricetype> priceTypes = productAuxiliar.getPricetypes();
        Product product = productAuxiliar;
        product.setPricetypes(null);
        product = productRepository.save(product);

        for (Pricetype priceType : priceTypes) {
            Type type = typeRepository.findById(priceType.getId().getTypeId()).orElse(null);

            PricetypePK pricetypePK =new PricetypePK();
            pricetypePK.setProductId(product.getId());
            pricetypePK.setTypeId(type.getId());

            priceType.setId(pricetypePK);
            priceType.setProduct(product);
            priceType.setType(type);
            pricetypesRepository.save(priceType);
        }
        return productRepository.save(product);
    }

//    public Product getProduct(Long id) {
//        return productRepository.getProduct(id);
//        return new Product();
//    }

//    public List<Product> getAllProducts() {
//        return (List<Product>) productRepository.findAll();
//    }

//    public List<Type> getAllProductType() {
//        return productRepository.getAllProductType();
//    }

}
