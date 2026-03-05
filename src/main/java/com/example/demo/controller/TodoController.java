package com.example.demo.controller;
import com.example.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/")
    public String getTodoList(Model model) {
        model.addAttribute("todos", todoService.getTodoList());
        return "todo-list";
    }
}
