package com.simpleSpringBootECommerce.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartDTO implements Serializable {

    private BigDecimal price;
    private Long productId;
    private Long typeId;
    private String priceAndType;

    public String getPriceAndType() {
        return priceAndType;
    }

    public void setPriceAndType(String priceAndType) {
        String[] output = priceAndType.split("#");
        setTypeId(new Long(output[0]));
        setPrice(new BigDecimal(output[1]));
        this.priceAndType = priceAndType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

}
