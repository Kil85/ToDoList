package com.example.ToDoList.logic;

import com.example.ToDoList.Model.TaskGroupRepository;
import com.example.ToDoList.Model.TaskRepository;
import com.example.ToDoList.Model.projection.GroupReadDTO;
import com.example.ToDoList.Model.projection.GroupWriteDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskGroupService {
    private final TaskGroupRepository _taskGroupRepository;
    private final TaskRepository _taskRepository;

    public TaskGroupService(TaskGroupRepository taskGroupRepository, TaskRepository taskRepository) {
        _taskGroupRepository = taskGroupRepository;
        _taskRepository = taskRepository;
    }

    public GroupReadDTO createGroup(GroupWriteDTO dto) {
        var result = _taskGroupRepository.save(dto.toGroup());
        return new GroupReadDTO(result);
    }

    public List<GroupReadDTO> findAll() {
        return _taskGroupRepository.findAll().stream()
                .map(GroupReadDTO::new)
                .collect(Collectors.toList());
    }

    public void toggleGroup(int id) {
        var group = _taskGroupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Group doesn't exist"));
        if (_taskRepository.existsByDoneIsFalseAndGroup_Id(id)) {
            throw new IllegalStateException("Not all tasks are done");
        }
        group.setDone(!group.isDone());
    }
}
