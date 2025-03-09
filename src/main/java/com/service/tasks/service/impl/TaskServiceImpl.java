package com.service.tasks.service.impl;

import com.service.tasks.dto.CreateTaskDTO;
import com.service.tasks.dto.TaskDTO;
import com.service.tasks.exception.TaskActionException;
import com.service.tasks.exception.TaskNotFoundException;
import com.service.tasks.mapping.TaskMapper;
import com.service.tasks.model.Task;
import com.service.tasks.repo.TaskRepo;
import com.service.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(TaskService.BEAN_NAME)
public class TaskServiceImpl implements TaskService {
    private final TaskRepo repo;

    @Autowired
    public TaskServiceImpl(@Qualifier(TaskRepo.BEAN_NAME) TaskRepo repo) {
        this.repo = repo;
    }

    @Override
    public TaskDTO createTask(CreateTaskDTO createTaskDTO) {
        final Task task = TaskMapper.INSTANCE.mapToModel(createTaskDTO);

        final Task saved =  repo.save(task);

        return TaskMapper.INSTANCE.mapToDTO(saved);
    }

    @Override
    public TaskDTO getTaskById(String id) {
        final long idValue;

        try {
            idValue = Long.parseLong(id);
        } catch (NumberFormatException _) {
            throw new TaskActionException("""
                    Task Id must be a numeric value.
                    Please try again with a proper value.
                    """);
        }

        Task taskFound = repo.findById(idValue)
                .orElseThrow(() -> new TaskNotFoundException(idValue));

        return TaskMapper.INSTANCE.mapToDTO(taskFound);
    }
}
