package com.freddy.ToDoList.controller;

import com.freddy.ToDoList.models.TodoItemModel;
import com.freddy.ToDoList.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class TodoFormController {

    @Autowired
    private TodoItemRepository todoItemRepository;


    @GetMapping("/create-todo")
    public String showCreateForm(TodoItemModel todoItem, Model model){
        model.addAttribute("todoItem", new TodoItemModel());
        return "add-todo-item";
    }

    @GetMapping("/edit/{id}")
    public String mostrarUpdateForm(@PathVariable("id") long id, Model model) {
        TodoItemModel todoItem = todoItemRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        model.addAttribute("todo", todoItem);
        return "update-todo-item";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") long id, Model model){
        TodoItemModel todoItem = todoItemRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id " + id + " not exist"));

        todoItemRepository.delete(todoItem);
        return "redirect:/";
    }


}
