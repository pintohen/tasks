package com.service.tasks.dto;

import lombok.Data;

@Data
public class TaskDTO {
    private String id;
    private String title;
    private String description;
    private String owner;
    private String status;
}
