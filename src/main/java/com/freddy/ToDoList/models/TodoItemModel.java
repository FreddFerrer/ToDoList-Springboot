package com.freddy.ToDoList.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.Instant;

@Entity
@Table(name = "todo_item")
public class TodoItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "la descripcion no puede estar vacia")
    private String description;

    @Getter
    @Setter
    private Boolean completed;

    @Getter
    @Setter
    private Instant created_date;

    @Getter
    @Setter
    private Instant modified_date;

    public TodoItemModel(String description, Boolean completed, Instant created_date, Instant modified_date) {
        this.description = description;
        this.completed = completed;
        this.created_date = created_date;
        this.modified_date = modified_date;
    }

    @Override
    public String toString() {
        return "TodoItemModel{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", created_date=" + created_date +
                ", modified_date=" + modified_date +
                '}';
    }
}
