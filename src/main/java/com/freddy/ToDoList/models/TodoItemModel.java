package com.freddy.ToDoList.models;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
@Table(name = "todo_item")
public class TodoItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public TodoItemModel() {
    }

    public TodoItemModel(String description) {
        this.description = description;
        this.completed = false;
        this.created_date = Instant.now();
        this.modified_date = Instant.now();
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
