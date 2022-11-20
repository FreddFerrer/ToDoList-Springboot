package com.freddy.ToDoList.config;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoItemDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLoggger(TodoItemData);

    @Override
    public void run(String... args) throws Exception {

    }
}
