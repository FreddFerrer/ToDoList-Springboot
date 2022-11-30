package com.freddy.ToDoList.config;


import com.freddy.ToDoList.models.TodoItemModel;
import com.freddy.ToDoList.repositories.TodoItemRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoItemDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);

    @Autowired
    private TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    public void loadData()  {
        if (todoItemRepository.count() == 0) {
            TodoItemModel item1 = new TodoItemModel("comprar lechelita");
            TodoItemModel item2 = new TodoItemModel("estudiar prog");

            todoItemRepository.save(item1);
            todoItemRepository.save(item2);
        }

        logger.info("numero de items: " + todoItemRepository.count());
    }
}
