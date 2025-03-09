package com.service.tasks.exception;

public class TaskNotFoundException extends TaskActionException {

    private TaskNotFoundException(String message) {
        super(message);
    }

    public TaskNotFoundException(Long id) {
        this(String.format("Task with id '%d' not found", id));
    }
}
