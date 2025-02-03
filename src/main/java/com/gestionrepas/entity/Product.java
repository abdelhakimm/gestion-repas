package com.gestionrepas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "products",
        uniqueConstraints = {@UniqueConstraint(columnNames = "product_name")}
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The product name is required")
    @Column(name = "product_name", nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "The price is required")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @NotNull(message = "The stock quantity is required")
    @Column(nullable = false)
    private Integer stockQuantity;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToMany
    @JoinTable(
            name = "dish_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private Set<Dish> dishes = new HashSet<>();

    public Product() {}

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public Product setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
        return this;
    }

    public Store getStore() {
        return store;
    }

    public Product setStore(Store store) {
        this.store = store;
        return this;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public Product setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
        return this;
    }
}
