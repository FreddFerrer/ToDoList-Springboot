package com.freddy.ToDoList.controller;

import java.time.Instant;
import java.time.ZoneId;

import javax.validation.Valid;

import com.freddy.ToDoList.models.TodoItemModel;
import com.freddy.ToDoList.repositories.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoListController {
    private final Logger logger = LoggerFactory.getLogger(TodoListController.class);

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/")
    public ModelAndView index() {
        logger.info("request to GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemRepository.findAll());
        modelAndView.addObject("today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
        return modelAndView;
    }

    @PostMapping("/todo")
    public String createTodoItem(@ModelAttribute @Valid TodoItemModel todoItem, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("todoItem", todoItem);
            return "add-todo-item";
        }

        todoItem.setCompleted(false);
        todoItem.setCreated_date(Instant.now());
        todoItem.setModified_date(Instant.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") long id, @Valid TodoItemModel todoItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            todoItem.setId(id);
            return "update-todo-item";
        }

        todoItem.setModified_date(Instant.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

}