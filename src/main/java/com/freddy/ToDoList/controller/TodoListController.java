package com.freddy.ToDoList.controller;

import com.freddy.ToDoList.models.TodoItemModel;
import com.freddy.ToDoList.repositories.TodoItemRepository;
import com.freddy.ToDoList.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TodoListController {

    @Autowired
    private TodoItemService todoItemService;



}
