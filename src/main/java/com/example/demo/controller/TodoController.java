package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/")
    public String getTodoList(Model model) {
        model.addAttribute("list", todoService.getTodoList());
        return "index.html";
    }

    @PostMapping("/add")
    public String addTodo(Todo todo) {
        todoService.addTodo(todo);
        return "redirect:/";
    }
}
