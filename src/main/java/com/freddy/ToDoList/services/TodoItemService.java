package com.freddy.ToDoList.services;

import com.freddy.ToDoList.models.TodoItemModel;
import com.freddy.ToDoList.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;




}
