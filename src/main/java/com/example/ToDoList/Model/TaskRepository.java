package com.example.ToDoList.Model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();

    Page<Task> findAll(Pageable page);

    Optional<Task> findById(Integer i);

    Task save(Task entity);

    boolean existsById(Integer id);

    boolean existsByDoneIsFalseAndGroup_Id(Integer id);


}
