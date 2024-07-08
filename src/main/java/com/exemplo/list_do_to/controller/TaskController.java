package com.exemplo.list_do_to.controller;

import com.exemplo.list_do_to.dto.TaskDTO;
import com.exemplo.list_do_to.model.Task;
import com.exemplo.list_do_to.repository.TasksRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TasksRepository tasksRepository;

    @GetMapping
    public ResponseEntity getTasks() {
        var allTasks = tasksRepository.findAll();
        return ResponseEntity.ok(allTasks);
    }

    @PostMapping
    public ResponseEntity addTask(@RequestBody @Valid TaskDTO taskDTO) {
        Task newTask = new Task(taskDTO);
        tasksRepository.save(newTask);
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTask(@RequestBody @Valid TaskDTO taskDTO) {
        Optional<Task> optionalTask = tasksRepository.findById(taskDTO.getId());

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setName(taskDTO.getName());
            task.setInitialDate(taskDTO.getInitialDate());
            task.setFinalDate(taskDTO.getFinalDate());
            task.setDescription(taskDTO.getDescription());
            task.setStatus(taskDTO.getStatus());
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTask(@PathVariable Long id) {
        Optional<Task> optionalTask = tasksRepository.findById(id);

        if (optionalTask.isPresent()) {
            tasksRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
