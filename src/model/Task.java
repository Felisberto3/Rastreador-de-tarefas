package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class Task {
    private int id;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;

    public Task(String description, String status) {
        this.id = new Random().nextInt(999999999);
        this.description = description;
        this.status = status;
        this.createdAt = LocalDateTime.now().toString();
        this.updatedAt = LocalDateTime.now().toString();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", description=" + description + ", status=" + status + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + "]";
    }

}