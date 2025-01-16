package com.gestionrepas.entity;

import com.gestionrepas.enums.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(
        name = "taches"
)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTask;

    @NotBlank(message = "le titre de la tache est obligatoire")
    @Column(nullable = false, length = 50)
    private String titre;

    @Column(nullable = true, length = 255)
    private String description;

    @NotBlank(message = "la date de la tâche est obligatoire")
    @Column(name = "date_execution" , nullable = false)
    private LocalDate date_execution;

    @NotBlank(message = "l'heure du début de la tâche est obligatoire")
    @Column(name = "heure_debut", nullable = false)
    private LocalTime heureDebut;

    @NotBlank(message = "l'heure de fin de la tâche est obligatoire")
    @Column(name = "heure_fin", nullable = false)
    private LocalTime heureFin;

    @NotBlank(message = "Le status est obligatoire")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "planning_id", nullable = false)
    private Planning planning;

    public Long getIdTask() {
        return idTask;
    }

    public Task setIdTask(Long idTask) {
        this.idTask = idTask;
        return this;
    }

    public String getTitre() {
        return titre;
    }

    public Task setTitre(String titre) {
        this.titre = titre;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDate_execution() {
        return date_execution;
    }

    public Task setDate_execution(LocalDate date_execution) {
        this.date_execution = date_execution;
        return this;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Task setStatus(TaskStatus status) {
        this.status = status;
        return this;
    }

    public Planning getPlanning() {
        return planning;
    }

    public Task setPlanning(Planning planning) {
        this.planning = planning;
        return this;
    }
}
