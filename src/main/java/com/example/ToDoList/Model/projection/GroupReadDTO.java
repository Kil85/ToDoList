package com.example.ToDoList.Model.projection;

import com.example.ToDoList.Model.Task;
import com.example.ToDoList.Model.TaskGroup;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupReadDTO {
    private String description;
    /**
     * Deadline from the latest task in the group
     */
    private LocalDateTime deadline;
    private Set<GroupTaskReadDTO> tasks;

    public GroupReadDTO(TaskGroup source) {
        this.description = source.getDescription();
        source.getTaskSet().stream()
                .map(Task::getDeadline)
                .max(LocalDateTime::compareTo)
                .ifPresent(task -> this.deadline = task);
        this.tasks = source.getTaskSet().stream()
                .map(GroupTaskReadDTO::new)
                .collect(Collectors.toSet());
    }

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

    public Set<GroupTaskReadDTO> getTasks() {
        return tasks;
    }

    public void setTasks(Set<GroupTaskReadDTO> tasks) {
        this.tasks = tasks;
    }
}
