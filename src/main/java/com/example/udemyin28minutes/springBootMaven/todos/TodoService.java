package com.example.udemyin28minutes.springBootMaven.todos;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static int todoCount=0;
    private static List<Todo> todos=new ArrayList<>();
    static {
        todos.add(new Todo(++todoCount,"sneha","learn spring boot", LocalDate.now().plusMonths(1),false));
        todos.add(new Todo(++todoCount,"sneha","watch a movie", LocalDate.now().plusDays(4),false));
        todos.add(new Todo(++todoCount,"sneha","call your best friend", LocalDate.now().plusWeeks(2),false));
    }

    public List<Todo> findByUserName(String username)
    {
        return todos;
    }
    public void addNewTodo(String ownerName, String description, LocalDate endDate, boolean done)
    {
        todos.add(new Todo(++todoCount,ownerName,description,endDate,done));
    }

    public void deleteByID(int id)
    {
        Predicate<? super Todo> predicate=todo -> todo.getId()==id;
        todos.removeIf(predicate);
    }
}
