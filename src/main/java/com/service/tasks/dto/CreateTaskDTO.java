package com.service.tasks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateTaskDTO {

    @NotBlank(message = "Title of the Task must be provided. Please provide its value and try again.")
    @JsonProperty("title")
    private String title;

    @Size(max = 2000, message = "Description of task shall be below 2000 characters. Please shorten the description and try again.")
    @JsonProperty("description")
    private String description;

    @NotBlank(message = "Task must have a owner. Please provide its value and try again.")
    @JsonProperty("owner")
    private String owner;
}
