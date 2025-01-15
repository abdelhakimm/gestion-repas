package com.gestionrepas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom d'utilisateur est obligatoire.")
    @Size(min = 4, max = 50, message = "Le nom d'utilisateur doit contenir entre 4 et 50 caractères.")
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @NotBlank(message = "l'email est obligatoire")
    @Size(max = 100, message = "L'adresse email ne peut pas dépasser 100 caractères.")
    @Email(message = "L'email doit être valide")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(min = 8, message = "Le mot de passe doit contenir au moin 8 charactéres")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "le rôle est obligatoire")
    @Pattern(regexp = "USER|ADMIN", message = "les rôle doit être USER ou ADMIN")
    @Column(nullable = false, length = 10)
    private String role;

    @PastOrPresent(message = "La date de création ne peut pas être dans le futur")
    @Column(name = "date_creation", nullable = false, updatable = false)
    private LocalDateTime dateCreation;

    @ManyToMany(mappedBy = "user")
    @JoinTable(
            name = "user_planning",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "planning_id")
    )
    private Set<Planning> plannings = new HashSet<>();

    public User() {
        this.dateCreation = LocalDateTime.now();
    }

    public Long getId() {
        return this.id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return this.email;
    }
    public User setEmail(String email) {
        this.email = email;
        return this;
    }
    public String getPassword() {
        return this.password;
    }
    public User setPassword(String password) {
        this.password = password;
        return this;
    }
    public String getRole() {
        return this.role;
    }

    public User setRole(String role) {
        this.role = role;
        return this;
    }
    public LocalDateTime getDateCreation() {
        return this.dateCreation;

    }
    public User setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }



    public Collection<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(Set<Planning> plannings) {
        this.plannings = plannings;
    }
}


