package com.gestionrepas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "schedules",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        }
)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The schedule name is required")
    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @NotNull(message = "The start date is required")
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull(message = "The end date is required")
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @ManyToMany
    private Set<User> users = new HashSet<User>();

    @OneToMany(mappedBy = "schedule")
    private Set<Task> tasks = new HashSet<Task>();

    public Long getId() {
        return id;
    }

    public Schedule setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Schedule setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Schedule setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Schedule setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Schedule setUsers(Set<User> users) {
        this.users = users;
        return this;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Schedule setTasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }
}
