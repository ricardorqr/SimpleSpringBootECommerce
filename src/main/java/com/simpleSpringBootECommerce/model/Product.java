package com.simpleSpringBootECommerce.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;


/**
 * The persistent class for the product database table.
 */
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String description;
    @NotNull
    private Integer pages;
    @NotNull
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate releasedate;
    @NotEmpty
    private String title;

    @OneToMany(mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<PriceType> priceTypes;

    public Product() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public LocalDate getReleasedate() {
        return this.releasedate;
    }

    public void setReleasedate(LocalDate releasedate) {
        this.releasedate = releasedate;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PriceType> getPriceTypes() {
        return this.priceTypes;
    }

    public void setPriceTypes(List<PriceType> priceTypes) {
        this.priceTypes = priceTypes;
    }

    public PriceType addPriceType(PriceType priceType) {
        getPriceTypes().add(priceType);
        priceType.setProduct(this);

        return priceType;
    }

    public PriceType removePriceType(PriceType priceType) {
        getPriceTypes().remove(priceType);
        priceType.setProduct(null);

        return priceType;
    }

}