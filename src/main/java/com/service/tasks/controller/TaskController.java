package com.service.tasks.controller;

import com.service.tasks.dto.CreateTaskDTO;
import com.service.tasks.dto.TaskDTO;
import com.service.tasks.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(@Qualifier(TaskService.BEAN_NAME) final TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody @Valid final CreateTaskDTO requestBody) {
        TaskDTO createdTask = taskService.createTask(requestBody);

        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable("id") final String id) {
        final TaskDTO foundTask = taskService.getTaskById(id);

        return ResponseEntity.ok(foundTask);
    }
}
