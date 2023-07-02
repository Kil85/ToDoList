package com.example.ToDoList.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "project_steps")
public class ProjectSteps {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Can not be empty")
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    private int DaysToDeadline;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    Project getProject() {
        return project;
    }

    void setProject(Project project) {
        this.project = project;
    }

    public int getDaysToDeadline() {
        return DaysToDeadline;
    }

    public void setDaysToDeadline(int daysToDeadline) {
        DaysToDeadline = daysToDeadline;
    }


}
