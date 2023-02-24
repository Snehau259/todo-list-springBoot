package com.example.udemyin28minutes.springBootMaven.todos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Todo {
   @Id @GeneratedValue
   private int id;
    private String ownerName;
    @Size(min = 10,message = "Enter atleast 10 characters")
    private String description;
    private LocalDate endDate;
    private boolean done;

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", description='" + description + '\'' +
                ", endDate=" + endDate +
                ", done=" + done +
                '}';
    }

    public Todo() {
    }

    public Todo(int id, String ownerName, String description, LocalDate endDate, boolean done) {
        this.id = id;
        this.ownerName = ownerName;
        this.description = description;
        this.endDate = endDate;
        this.done = done;
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
        this.done = done;
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
        return done;
    }
}
