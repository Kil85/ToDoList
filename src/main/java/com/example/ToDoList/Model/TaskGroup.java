package com.example.ToDoList.Model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "task_group")
public class TaskGroup extends BaseTask {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<Task> taskSet;
    @Embedded
    private Audit audit = new Audit();

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public TaskGroup() {
    }

    public Set<Task> getTaskSet() {
        return taskSet;
    }

    public void setTaskSet(Set<Task> taskSet) {
        this.taskSet = taskSet;
    }
}
