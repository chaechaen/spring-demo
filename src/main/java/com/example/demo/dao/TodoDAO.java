package com.example.demo.dao;

import com.example.demo.model.Todo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TodoDAO {

    private static List<Todo> todos;

    static {
        todos = new ArrayList<>();

        Todo t1 = new Todo();
        t1.setCategory("Study");
        t1.setTitle("Spring DispatcherServlet 복습");
        t1.setSummary("Controller-Service-DAO 흐름 정리");
        t1.setDate(LocalDate.of(2026, 3, 10));

        Todo t2 = new Todo();
        t2.setCategory("Project");
        t2.setTitle("SSR Todo 페이지 만들기");
        t2.setSummary("Thymeleaf로 서버 렌더링 구현");
        t2.setDate(LocalDate.of(2026, 3, 12));

        Todo t3 = new Todo();
        t3.setCategory("Career");
        t3.setTitle("금융 IT 공부");
        t3.setSummary("PG / VAN / 결제 인프라 구조 정리");
        t3.setDate(LocalDate.of(2026, 3, 15));

        Todo t4 = new Todo();
        t4.setCategory("Health");
        t4.setTitle("요가하기");
        t4.setSummary("스트레스 관리");
        t4.setDate(LocalDate.of(2026, 3, 8));

        todos.add(t1);
        todos.add(t2);
        todos.add(t3);
        todos.add(t4);
    }

    public List<Todo> findAll() {
        // DB 조회했다고 가정
        return todos;
    }
}
