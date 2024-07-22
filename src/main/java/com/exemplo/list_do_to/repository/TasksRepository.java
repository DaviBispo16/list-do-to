package com.exemplo.list_do_to.repository;

import com.exemplo.list_do_to.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Task, Long> {
}
