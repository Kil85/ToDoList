package com.example.ToDoList.logic;

import com.example.ToDoList.Model.*;
import com.example.ToDoList.Model.projection.GroupReadDTO;
import com.example.ToDoList.TaskConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private final ProjectRepository _projectRepo;
    private final TaskGroupService _taskGroupService;
    private final TaskConfigurationProperties _configuration;

    public ProjectService(ProjectRepository projectRepo, TaskGroupService taskGroupService, TaskConfigurationProperties configuration) {
        _projectRepo = projectRepo;
        _taskGroupService = taskGroupService;
        _configuration = configuration;
    }

    public Project CreateProject(Project entity) {
        return _projectRepo.save(entity);
    }

    public Project findById(Integer id) {
        return _projectRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project does not exist"));
    }

    public List<Project> findAll() {
        return _projectRepo.findAll();
    }

    public GroupReadDTO createGroup(int projectId, LocalDateTime deadline) {
        var project = findById(projectId);
        var result = new TaskGroup();
        result.setDescription(project.getDescription());
        result.setTaskSet(project.getProjectSteps().stream()
                .map(projectSteps -> new Task(
                        projectSteps.getDescription(),
                        deadline.plusDays(projectSteps.getDaysToDeadline())
                )).collect(Collectors.toSet())
        );
        return new GroupReadDTO(result);
    }
}
