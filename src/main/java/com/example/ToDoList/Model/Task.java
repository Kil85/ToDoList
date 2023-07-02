package com.example.ToDoList.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task extends BaseTask {

    private LocalDateTime deadline;

    @ManyToOne
    @JoinColumn(name = "task_group_id")
    private TaskGroup group;

    @Embedded
    private Audit audit = new Audit();

    public Task() {
    }

    public Task(String desc, LocalDateTime dead) {
        this.setDescription(desc);
        this.deadline = dead;
        this.setDone(false);
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }


    TaskGroup getGroup() {
        return group;
    }

    void setGroup(TaskGroup group) {
        this.group = group;
    }


    public void updateTask(Task task) {
        setDescription(task.getDescription());
        setDone(task.isDone());
        deadline = task.deadline;
        group = task.group;
    }
}
