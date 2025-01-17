package com.example.ToDoList.Model.projection;

import com.example.ToDoList.Model.Task;

import java.time.LocalDateTime;

public class GroupTaskWriteDTO {
    private String description;
    private LocalDateTime deadline;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    Task toTask() {
        return new Task(description, deadline);
    }
}
