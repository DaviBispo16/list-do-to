package com.exemplo.list_do_to.controllers;

import com.exemplo.list_do_to.model.task.TaskDTO;
import com.exemplo.list_do_to.model.task.Task;
import com.exemplo.list_do_to.model.user.User;
import com.exemplo.list_do_to.repositories.TasksRepository;
import com.exemplo.list_do_to.repositories.UserRepository;
import com.exemplo.list_do_to.services.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public ResponseEntity getTasks() {
        var allTasks = tasksRepository.findAll();
        return ResponseEntity.ok(allTasks);
    }

    @PostMapping
    public ResponseEntity addTask(@RequestBody @Valid TaskDTO taskDTO) {
        var login = tokenService.validateToken(taskDTO.getToken());

        User user_id = userRepository.findOneByUsername(login);

        Task newTask = new Task(taskDTO, user_id.getId());
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
            task.setInitial_date(taskDTO.getInitialDate());
            task.setFinal_date(taskDTO.getFinalDate());
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
    //TODO: GET ONE TASK
//    @GetMapping("/{id}")
//    public ResponseEntity getOneTask(@PathVariable Integer id) {
//        Optional<Task> optionalTask = tasksRepository.findById(Long.valueOf(id));
//
//        return ResponseEntity.ok(optionalTask);
//
//    }
}
