package com.service.tasks.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_task")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, length = 100)
    private String owner;

    @Column()
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
}
