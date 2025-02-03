package com.gestionrepas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "dishes",
        uniqueConstraints = {@UniqueConstraint(columnNames = "dish_name")}
)
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The dish name is required")
    @Column(name = "dish_name", nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "dish_product",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

    @ManyToMany(mappedBy = "dishes")
    private Set<Meal> meals = new HashSet<>();

    public Dish() {}

    public Long getId() {
        return id;
    }

    public Dish setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dish setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Dish setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Dish setProducts(Set<Product> products) {
        this.products = products;
        return this;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public Dish setMeals(Set<Meal> meals) {
        this.meals = meals;
        return this;
    }
}
