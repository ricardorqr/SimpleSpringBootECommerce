package com.simpleSpringBootECommerce.model;

import java.math.BigDecimal;

public class CartItem {

	private Pricetype priceType;
	private Product product;

	public CartItem(Product product, Pricetype priceType) {
		this.product = product;
		this.priceType = priceType;
	}

//	public BigDecimal getPrice() {
//		return product.priceFor(priceType);
//	}

//	public BigDecimal getTotal(int quantity) {
//		return this.getPrice().multiply(new BigDecimal(quantity));
//	}

	public Pricetype getPriceType() {
		return priceType;
	}

	public void setPriceType(Pricetype priceType) {
		this.priceType = priceType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((priceType == null) ? 0 : priceType.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (priceType != other.priceType)
			return false;
		if (product == null) {
            return other.product == null;
		} else return product.equals(other.product);
    }

	@Override
	public String toString() {
		return "CartItem [priceType=" + priceType + ", product=" + product + "]";
	}

}
