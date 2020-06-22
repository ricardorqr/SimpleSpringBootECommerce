//package com.simpleSpringBootECommerce.modelOld;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotEmpty
//    private String title;
//
//    @NotEmpty
//    @Size(max = 1000)
//    private String description;
//
//    @NotNull
//    @DateTimeFormat(pattern = "MM/dd/yyyy")
//    private LocalDate releaseDate;
//
//    @NotNull
//    private Integer pages;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    private Set<Price> prices = new HashSet<>();
//
//    public BigDecimal priceFor(PriceType priceType) {
//        return prices.stream().filter(price -> price.getPriceType().equals(priceType)).findFirst().get().getValue();
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Integer getPages() {
//        return pages;
//    }
//
//    public void setPages(Integer pages) {
//        this.pages = pages;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Set<Price> getPrices() {
//        return prices;
//    }
//
//    public void setPrices(Set<Price> prices) {
//        this.prices = prices;
//    }
//
//    public LocalDate getReleaseDate() {
//        return releaseDate;
//    }
//
//    public void setReleaseDate(LocalDate releaseDate) {
//        this.releaseDate = releaseDate;
//    }
//
//    @Override
//    public String toString() {
//        return "Product [id=" + id + ", title=" + title + ", description=" + description + ", releaseDate="
//                + releaseDate + ", pages=" + pages + ", prices=" + prices + "]";
//    }
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((id == null) ? 0 : id.hashCode());
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        Product other = (Product) obj;
//        if (id == null) {
//            return other.id == null;
//        } else return id.equals(other.id);
//    }
//
//}