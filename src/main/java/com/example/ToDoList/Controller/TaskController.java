package com.example.ToDoList.Controller;

import com.example.ToDoList.Model.Task;
import com.example.ToDoList.Model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@Controller
public class TaskController {

    private final TaskRepository repository;
    private static final Logger _logger = LoggerFactory.getLogger(TaskController.class);

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tasks", params = {"!sort", "!page", "!size"})
    public ResponseEntity<?> ReadAllTasks() {
        _logger.warn("Reading all tasks");
        return ResponseEntity.ok(repository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tasks")
    public ResponseEntity<?> ReadAllTasks(Pageable page) {
        _logger.info("Paging");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/tasks")
    public ResponseEntity<?> CreateTask(@RequestBody @Valid Task task) {
        _logger.info("Task saved");
        Task result = repository.save((task));
        return ResponseEntity.created(URI.create("/tasks/" + result.getId())).build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/tasks/{id}")
    public ResponseEntity<?> UpdateTask(@RequestBody @Valid Task task, @PathVariable int id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        task.setId(id);
        repository.save(task);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(method = RequestMethod.GET, path = "/tasks/{id}")
    public ResponseEntity<?> GetTaskById(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
