package com.simpleSpringBootECommerce.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;


/**
 * The persistent class for the type database table.
 */
@Entity
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String type;

    @OneToMany(mappedBy = "type",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<PriceType> priceTypes;

    public Type() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PriceType> getPriceTypes() {
        return this.priceTypes;
    }

    public void setPriceTypes(List<PriceType> priceTypes) {
        this.priceTypes = priceTypes;
    }

    public PriceType addPriceType(PriceType priceType) {
        getPriceTypes().add(priceType);
        priceType.setType(this);

        return priceType;
    }

    public PriceType removePriceType(PriceType priceType) {
        getPriceTypes().remove(priceType);
        priceType.setType(null);

        return priceType;
    }

}