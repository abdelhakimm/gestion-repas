package com.gestionrepas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "plannings",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "nom")
        }
)
public class Planning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Il faut un nom au planning")
    @Column(name = "nom", nullable = false, unique = true, length = 50)
    private String nom;

    @NotNull(message = "La date de début est obligatoire")
    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @NotNull(message = "La date de fin est obligatoire")
    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;


    @ManyToMany
    private Set<User> users = new HashSet<User>();

    @OneToMany(mappedBy = "planning")
    private Set<Task> tasks = new HashSet<Task>();

    public Long getId() {
        return id;
    }

    public Planning setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public Planning setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public Planning setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
        return this;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public Planning setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Planning setUsers(Set<User> users) {
        this.users = users;
        return this;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Planning setTasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }
}
