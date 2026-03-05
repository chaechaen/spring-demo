package com.example.demo.service;

import com.example.demo.dao.TodoDAO;
import com.example.demo.model.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoDAO todoDAO;

    public List<Todo> getTodoList() {
        return todoDAO.findAll();
    }

    public void addTodo(Todo todo) {
        todoDAO.save(todo);
    }
}
