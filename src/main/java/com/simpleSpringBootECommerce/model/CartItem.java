package com.simpleSpringBootECommerce.model;

import java.math.BigDecimal;

public class CartItem {

    private Product product;
    private Type type;
    private BigDecimal price;

    public CartItem(Product product, Type type, BigDecimal price) {
        this.product = product;
        this.type = type;
        this.price = price;
    }

    public BigDecimal getTotal(int quantity) {
        return this.getPrice().multiply(new BigDecimal(quantity));
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItem)) return false;

        CartItem cartItem = (CartItem) o;

        if (getProduct() != null ? !getProduct().equals(cartItem.getProduct()) : cartItem.getProduct() != null)
            return false;
        return getType() != null ? getType().equals(cartItem.getType()) : cartItem.getType() == null;
    }

    @Override
    public int hashCode() {
        int result = getProduct() != null ? getProduct().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }
}
