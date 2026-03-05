package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Todo {
    private String category;
    private String title;
    private String summary;
    private LocalDate date;
}
