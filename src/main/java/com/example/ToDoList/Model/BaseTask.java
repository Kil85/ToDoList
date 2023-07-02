package com.example.ToDoList.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@MappedSuperclass

abstract class BaseTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Can not be empty :<")
    private String description;
    private boolean done;


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

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }
}
