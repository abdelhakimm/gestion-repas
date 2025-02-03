package com.gestionrepas.entity;

import com.gestionrepas.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
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

    @NotBlank(message = "Username is required.")
    @Size(min = 4, max = 50, message = "Username must be between 4 and 50 characters.")
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @NotBlank(message = "Email is required.")
    @Size(max = 100, message = "Email must not exceed 100 characters.")
    @Email(message = "Email must be valid.")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private UserRole role;

    @PastOrPresent(message = "Creation date cannot be in the future.")
    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    @ManyToMany
    @JoinTable(
            name = "user_schedule",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id")
    )
    private Set<Schedule> schedules = new HashSet<>();

    public User() {
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

    public UserRole getRole() {
        return this.role;
    }

    public User setRole(UserRole role) {
        this.role = role;
        return this;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public User setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;

        if (id != null && user.id != null) {
            return id.equals(user.id);
        }
        return email.equals(user.email) && username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return (id != null) ? Objects.hash(id) : Objects.hash(email, username);
    }

}
