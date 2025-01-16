package com.gestionrepas.enums;

public enum TaskStatus {
    TODO("À faire"),
    PENDING("En attente"),
    IN_PROGRESS("En cours"),
    DONE("Terminé");

    private final String displayName;

    TaskStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
