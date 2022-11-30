package com.freddy.ToDoList.repositories;

import com.freddy.ToDoList.models.TodoItemModel;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TodoItemRepository extends CrudRepository<TodoItemModel, Long> {


}
