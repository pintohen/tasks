package com.service.tasks.exception;

public class TaskActionException extends IllegalArgumentException {
    public TaskActionException(String message) {
        super(message);
    }
}
