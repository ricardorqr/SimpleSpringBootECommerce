package com.simpleSpringBootECommerce.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the pricetype database table.
 */
@Entity
public class Pricetype implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PricetypePK id;
    private BigDecimal value;

    @ManyToOne(cascade = {CascadeType.ALL})
    @MapsId("product_id")
    private Product product;

    @ManyToOne(cascade = {CascadeType.ALL})
    @MapsId("type_id")
    private Type type;

    public Pricetype() {

    }

    public PricetypePK getId() {
        return this.id;
    }

    public void setId(PricetypePK id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}