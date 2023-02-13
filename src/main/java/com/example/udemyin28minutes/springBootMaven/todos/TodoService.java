package com.example.udemyin28minutes.springBootMaven.todos;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos=new ArrayList<>();
    static {
        todos.add(new Todo(1,"sneha","learn spring boot", LocalDate.now().plusMonths(1),false));
        todos.add(new Todo(2,"sneha","watch a movie", LocalDate.now().plusDays(4),false));
        todos.add(new Todo(3,"sneha","call your best friend", LocalDate.now().plusWeeks(2),false));
    }

    public List<Todo> findByUserName(String username)
    {
        return todos;
    }
}
