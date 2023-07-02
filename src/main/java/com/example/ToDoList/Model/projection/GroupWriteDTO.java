package com.example.ToDoList.Model.projection;

import com.example.ToDoList.Model.TaskGroup;

import java.util.Set;
import java.util.stream.Collectors;

public class GroupWriteDTO {
    private String description;
    private Set<GroupTaskWriteDTO> tasks;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<GroupTaskWriteDTO> getTasks() {
        return tasks;
    }

    public void setTasks(Set<GroupTaskWriteDTO> tasks) {
        this.tasks = tasks;
    }

    public TaskGroup toGroup() {
        var result = new TaskGroup();
        result.setTaskSet(
                tasks.stream()
                        .map(GroupTaskWriteDTO::toTask)
                        .collect(Collectors.toSet()));

        result.setDescription(this.description);

        return result;
    }
}
