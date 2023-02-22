package com.example.udemyin28minutes.springBootMaven.todos;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
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
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUserName("sneha");
        model.addAttribute("todos", todos);
        return "todoController";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showAddNewTodoPage(ModelMap model) {
        String userName = (String) model.get("name");
        Todo todo = new Todo(0, userName, "", LocalDate.now(), false);
        model.put("todo", todo);
        return "AddTodo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addTodos(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "AddTodo";
        }
        else {
            List<Todo> todos = todoService.findByUserName("sneha");
//        model.addAttribute("todos",todos);
            String userName = (String) model.get("name");
            todoService.addNewTodo(userName, todo.getDescription(), LocalDate.now().plusDays(6), false);
            return "redirect:list-todos";
        }
    }

    @RequestMapping(value = "delete-todos", method = RequestMethod.GET)
    public String deleteTodos(@RequestParam int id)
    {
        todoService.deleteByID(id);
        return "redirect:list-todos";
    }
}
