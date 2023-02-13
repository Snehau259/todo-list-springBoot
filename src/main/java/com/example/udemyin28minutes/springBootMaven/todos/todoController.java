package com.example.udemyin28minutes.springBootMaven.todos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class todoController {
    private TodoService todoService;

    public todoController(TodoService todoService) {
//        super();
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model)
    {
        List<Todo> todos = todoService.findByUserName("sneha");
        model.addAttribute("todos",todos);
        return "todoController";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String showAddNewTodoPage()
    {
        return "AddTodo";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
    public String addTodos(ModelMap model)
    { List<Todo> todos = todoService.findByUserName("sneha");
//        model.addAttribute("todos",todos);
        return "redirect:list-todos";
    }
}
