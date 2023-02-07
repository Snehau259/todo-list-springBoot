package com.example.udemyin28minutes.springBootMaven.todos;

import java.time.LocalDate;

public class Todo {
    private int id;
    private String ownerName;
    private String description;
    private LocalDate endDate;
    private boolean isDone;

    public Todo(int id, String ownerName, String description, LocalDate endDate, boolean isDone) {
        this.id = id;
        this.ownerName = ownerName;
        this.description = description;
        this.endDate = endDate;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", description='" + description + '\'' +
                ", endDate=" + endDate +
                ", isDone=" + isDone +
                '}';
    }
}
