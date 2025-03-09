package com.service.tasks.exception.handler;

import com.service.tasks.constant.TaskActionConstants;
import com.service.tasks.exception.TaskActionException;
import com.service.tasks.exception.TaskNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TaskActionExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {
            TaskActionException.class
    })
    protected ResponseEntity<Object> handleTaskActionException(TaskActionException ex) {
        if (ex instanceof TaskNotFoundException) {
            return ResponseEntity
                    .notFound()
                    .header(TaskActionConstants.TASK_API_MESSAGE_HEADER, ex.getMessage())
                    .build();
        }


        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
