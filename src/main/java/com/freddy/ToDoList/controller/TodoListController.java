package com.freddy.ToDoList.controller;

import com.freddy.ToDoList.models.TodoItemModel;
import com.freddy.ToDoList.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/todoitems")
public class TodoListController {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping
    public ArrayList<TodoItemModel> obtenerTareas(){
        return (ArrayList<TodoItemModel>) todoItemRepository.findAll();
    }

    @PostMapping
    public TodoItemModel guardarTarea(@RequestBody TodoItemModel item){
        return todoItemRepository.save(item);
    }

    @GetMapping(path = "/{id}")
    public Optional obtenerPorId(@PathVariable("id") Long id){
        return todoItemRepository.findById(id);
    }

    @DeleteMapping( path = "/{id}")
    public void eliminarPorId(@PathVariable("id") Long id){
        todoItemRepository.deleteById(id);
    }

}
