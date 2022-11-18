package com.freddy.ToDoList.controller;

import com.freddy.ToDoList.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TodoListController {

    @Autowired
    private TodoItemRepository todoItemRepository;


}
