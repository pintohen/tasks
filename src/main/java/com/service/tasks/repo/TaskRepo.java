package com.service.tasks.repo;

import com.service.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(TaskRepo.BEAN_NAME)
public interface TaskRepo extends JpaRepository<Task, Long> {
    String BEAN_NAME = "com.service.tasks.repo.TaskRepo";

}
