package com.example.ToDoList.Model;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    List<Project> findAll();

    Project save(Project entity);

    Optional<Project> findById(Integer id);
}
