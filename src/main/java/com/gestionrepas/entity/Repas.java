package com.gestionrepas.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "repas")
public class Repas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
