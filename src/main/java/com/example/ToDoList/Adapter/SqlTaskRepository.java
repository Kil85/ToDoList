package com.example.ToDoList.Adapter;

import com.example.ToDoList.Model.Task;
import com.example.ToDoList.Model.TaskRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {
    @Override
    @Query(nativeQuery = true, value = "select count(*) > 0 from tasks where id=:id")
    boolean existsById(@Param(value = "id") Integer id);

    @Override
    boolean existsByDoneIsFalseAndGroup_Id(Integer id);
}
