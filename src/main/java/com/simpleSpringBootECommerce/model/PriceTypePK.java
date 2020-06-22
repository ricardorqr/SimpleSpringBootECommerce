package com.simpleSpringBootECommerce.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pricetype database table.
 */
@Embeddable
public class PriceTypePK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "type_id")
    private Long typeId;

    public PriceTypePK() {

    }

    public Long getProductId() { return this.productId; }

    public void setProductId(Long productId) { this.productId = productId; }

    public Long getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PriceTypePK)) {
            return false;
        }
        PriceTypePK castOther = (PriceTypePK) other;
        return
                (this.productId == castOther.productId)
                        && (this.typeId == castOther.typeId);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + Long.hashCode(this.productId);
        hash = hash * prime + Long.hashCode(this.typeId);
        return hash;
    }

}