//package com.simpleSpringBootECommerce.modelOld;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//
//@Entity
//public class Price {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private BigDecimal value;
//    private PriceType priceType;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    private Product product;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public PriceType getPriceType() {
//        return priceType;
//    }
//
//    public void setPriceType(PriceType priceType) {
//        this.priceType = priceType;
//    }
//
//    public BigDecimal getValue() {
//        return value;
//    }
//
//    public void setValue(BigDecimal value) {
//        this.value = value;
//    }
//
//    @Override
//    public String toString() {
//        return "Price{" +
//                "id=" + id +
//                ", value=" + value +
//                ", priceType=" + priceType +
//                ", product=" + product +
//                '}';
//    }
//
//}
