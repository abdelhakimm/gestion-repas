package com.gestionrepas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "meals",
        uniqueConstraints = {@UniqueConstraint(columnNames = "meal_name")}
)
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The meal name is required")
    @Column(name = "meal_name", nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    // ✅ Relation ManyToMany avec Dish (un repas contient plusieurs plats)
    @ManyToMany
    @JoinTable(
            name = "meal_dish",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private Set<Dish> dishes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    public Meal() {}

    public Long getId() {
        return id;
    }

    public Meal setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Meal setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Meal setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public Meal setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
        return this;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Meal setSchedule(Schedule schedule) {
        this.schedule = schedule;
        return this;
    }
}
