package com.freddy.ToDoList.controller;

import com.freddy.ToDoList.models.TodoItemModel;
import com.freddy.ToDoList.repositories.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/todoitems")
public class TodoListController {

    private final Logger logger = LoggerFactory.getLogger(TodoListController.class);

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/")
    public ModelAndView index(){
        logger.info("request to GET index");
        ModelAndView model = new ModelAndView("index");
        return model;
    }


}
