package com.freddy.ToDoList.repositories;

import com.freddy.ToDoList.models.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepository extends CrudRepository<Long, TodoItem> {
}
