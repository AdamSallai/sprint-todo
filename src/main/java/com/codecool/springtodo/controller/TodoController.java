package com.codecool.springtodo.controller;

import com.codecool.springtodo.entity.Todo;
import com.codecool.springtodo.repository.TodoRepository;
import com.codecool.springtodo.service.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@CrossOrigin
@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    private static final String SUCCESS = "{\"success\":true}";

    @PostMapping(value = "/addTodo", consumes = "application/x-www-form-urlencoded", produces = "application/x-www-form-urlencoded")
    public ResponseEntity<String> addTodo(@RequestParam String title) {
        Todo todo = Todo.builder()
                .title(title)
                .status(Status.ACTIVE)
                .build();
        System.out.println(todo);
        todoRepository.save(todo);
        return ResponseEntity.ok(SUCCESS);
    }

    @PostMapping("/list")
    public List<Todo> listTodos() {
        return todoRepository.findAll();
    }

    @DeleteMapping("/todos/completed")
    public ResponseEntity<String> completed() {
        return ResponseEntity.ok(SUCCESS);
    }

    @PutMapping("/todos/toggle_all")
    public ResponseEntity<String> toggleAll() {
        return ResponseEntity.ok(SUCCESS);
    }

    @DeleteMapping("/todos/:id")
    public ResponseEntity<String> deleteById() {
        return ResponseEntity.ok(SUCCESS);
    }

    @PutMapping("/todos/:id")
    public ResponseEntity<String> updateById() {
        return ResponseEntity.ok(SUCCESS);
    }

    @GetMapping("/todos/:id")
    public ResponseEntity<String> getById() {
        return ResponseEntity.ok(SUCCESS);
    }

    @PutMapping("/todos/:id/toggle_status")
    public ResponseEntity<String> toggleStatusById() {
        return ResponseEntity.ok(SUCCESS);
    }

}
