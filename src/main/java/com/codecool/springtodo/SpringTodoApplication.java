package com.codecool.springtodo;

import com.codecool.springtodo.entity.Todo;
import com.codecool.springtodo.repository.TodoRepository;
import com.codecool.springtodo.service.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.List;

@SpringBootApplication
public class SpringTodoApplication {

    @Autowired
    private TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringTodoApplication.class, args);
    }

    @Bean
    @Profile("production")
    CommandLineRunner init() {
        return args -> {
            Todo firstTodoItem = Todo.builder()
                    .title("first TODO item")
                    .status(Status.ACTIVE)
                    .build();
            Todo secondTodoItem = Todo.builder()
                    .title("second TODO item")
                    .status(Status.ACTIVE)
                    .build();
            Todo thirdTodoItem = Todo.builder()
                    .title("third TODO item")
                    .status(Status.ACTIVE)
                    .build();

            todoRepository.saveAll(List.of(firstTodoItem, secondTodoItem ,thirdTodoItem));
        };
    }
}
