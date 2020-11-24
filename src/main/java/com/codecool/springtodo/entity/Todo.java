package com.codecool.springtodo.entity;

import com.codecool.springtodo.service.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Long todoId;

    private String title;

    @Enumerated(EnumType.STRING)
    private Status status;

    private boolean completed;

}
