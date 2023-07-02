package com.example.ToDoList.Model.projection;

import com.example.ToDoList.Model.Task;

import java.time.LocalDateTime;

public class GroupTaskReadDTO {
    private String description;
    private boolean done;

    public GroupTaskReadDTO(Task task) {
        this.done = task.isDone();
        this.description = task.getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
