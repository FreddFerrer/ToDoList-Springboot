package com.freddy.ToDoList.controller;

import com.freddy.ToDoList.models.TodoItemModel;
import com.freddy.ToDoList.repositories.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.Instant;
import java.time.ZoneId;


@Controller
public class TodoListController {

    private final Logger logger = LoggerFactory.getLogger(TodoListController.class);

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/")
    public ModelAndView index(){
        logger.info("request to GET index");
        ModelAndView model = new ModelAndView("index");
        model.addObject("todoItems", todoItemRepository.findAll());
        model.addObject("today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
        return model;
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid @ModelAttribute TodoItemModel todoItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-todo-item";
        }

        todoItem.setCreated_date(Instant.now());
        todoItem.setModified_date(Instant.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

    @PostMapping("/todo/{id}")
    public String actualizarLista(@PathVariable("id") long id,
                                  @Valid TodoItemModel todoItem, BindingResult result,
                                  Model model){
        if(result.hasErrors()){
            todoItem.setId(id);
            return "update-todo-item";
        }

        todoItem.setModified_date(Instant.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }




}
