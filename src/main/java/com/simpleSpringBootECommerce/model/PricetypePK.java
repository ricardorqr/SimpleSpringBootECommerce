package com.simpleSpringBootECommerce.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pricetype database table.
 */
@Embeddable
public class PricetypePK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "type_id")
    private Long typeId;

    public PricetypePK() {

    }

    public Long getProductId() { return this.productId; }

    public void setProductId(Long productId) { this.productId = productId; }

    public Long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PricetypePK)) return false;

        PricetypePK that = (PricetypePK) o;

        if (getProductId() != null ? !getProductId().equals(that.getProductId()) : that.getProductId() != null)
            return false;
        return getTypeId() != null ? getTypeId().equals(that.getTypeId()) : that.getTypeId() == null;
    }

    @Override
    public int hashCode() {
        int result = getProductId() != null ? getProductId().hashCode() : 0;
        result = 31 * result + (getTypeId() != null ? getTypeId().hashCode() : 0);
        return result;
    }
}