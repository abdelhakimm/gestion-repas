package com.gestionrepas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "repas",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "nom_repas")
})
public class Repas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "le nom du repas doit être obligatoire")
    @Column(name = "nom_repas", nullable = false, length = 100)
    private String nomRepas;


    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    private LocalDate date;




    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
