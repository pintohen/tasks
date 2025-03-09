package com.service.tasks.mapping;

import com.service.tasks.dto.CreateTaskDTO;
import com.service.tasks.dto.TaskDTO;
import com.service.tasks.exception.TaskActionException;
import com.service.tasks.model.Task;
import com.service.tasks.model.TaskStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(target = "status", expression = "java(com.service.tasks.model.TaskStatus.CREATED)")
    Task mapToModel(CreateTaskDTO createTaskDTO);

    @Mapping(target = "status", source = "status")
    TaskDTO mapToDTO(Task task);


    default TaskStatus mapTaskStatus(String status) {
        try {
            return TaskStatus.valueOf(status);
        } catch (IllegalArgumentException e) {
            throw new TaskActionException("""
                Value of Task Status provided could not be resolved.
                Further action was not completed, please provide a valid value.
            """);
        }
    }
}
