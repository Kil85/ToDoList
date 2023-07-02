package com.example.ToDoList.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Can not be empty")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<ProjectSteps> projectSteps;

    @OneToMany(mappedBy = "project")
    private Set<TaskGroup> taskGroups;

    Set<TaskGroup> getTaskGroups() {
        return taskGroups;
    }

    void setTaskGroups(Set<TaskGroup> taskGroups) {
        this.taskGroups = taskGroups;
    }

    public int getId() {
        return id;
    }

    Set<ProjectSteps> getProjectSteps() {
        return projectSteps;
    }

    void setProjectSteps(Set<ProjectSteps> projectSteps) {
        this.projectSteps = projectSteps;
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
}
