package com.example.ToDoList.Adapter;

import com.example.ToDoList.Model.Project;
import com.example.ToDoList.Model.ProjectRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlProjectRepository extends ProjectRepository, JpaRepository<Project, Integer> {

    @Override
    @Query("from Project p join fetch p.projectSteps")
    List<Project> findAll();


}
