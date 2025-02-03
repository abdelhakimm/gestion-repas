package com.gestionrepas.entity;

import com.gestionrepas.enums.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The task title is required")
    @Column(nullable = false, length = 50)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "The task date is required")
    @Column(name = "execution_date", nullable = false)
    private LocalDate executionDate;

    @NotNull(message = "The start time is required")
    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @NotNull(message = "The end time is required")
    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    public Long getId() {
        return id;
    }

    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public Task setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
        return this;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public Task setStartTime(LocalTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Task setEndTime(LocalTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Task setStatus(TaskStatus status) {
        this.status = status;
        return this;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Task setSchedule(Schedule schedule) {
        this.schedule = schedule;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;

        if (id != null && task.id != null) {
            return id.equals(task.id);
        }

        return title.equals(task.title) &&
                executionDate.equals(task.executionDate) &&
                schedule.equals(task.schedule);
    }

    @Override
    public int hashCode() {
        return (id != null) ? Objects.hash(id) : Objects.hash(title, executionDate, schedule);
    }

}
