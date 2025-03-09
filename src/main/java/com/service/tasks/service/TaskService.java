package com.service.tasks.service;

import com.service.tasks.dto.CreateTaskDTO;
import com.service.tasks.dto.TaskDTO;

public interface TaskService {
    String BEAN_NAME = "com.service.tasks.service.TaskService";

    TaskDTO createTask(CreateTaskDTO taskDTO);
    TaskDTO getTaskById(String id);
}
