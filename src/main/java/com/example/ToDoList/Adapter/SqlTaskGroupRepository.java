package com.example.ToDoList.Adapter;

import com.example.ToDoList.Model.TaskGroup;
import com.example.ToDoList.Model.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlTaskGroupRepository extends TaskGroupRepository, JpaRepository<TaskGroup, Integer> {

    @Override
    @Query("from TaskGroup t join fetch t.taskSet")
    List<TaskGroup> findAll();

    @Override
    boolean existsByDoneIsFalseAndProjectId(Integer id);
}
