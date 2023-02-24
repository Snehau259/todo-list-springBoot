package com.example.udemyin28minutes.springBootMaven.todos;

import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    private TodoRepository todoRepository;

    public todoController() {
    }

    public todoController(TodoService todoService, TodoRepository todoRepository) {
//        super();
        this.todoService = todoService;
        this.todoRepository=todoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        String userName = getAuthenticatedUserName();
        List<Todo> todos = todoRepository.findByOwnerName(userName);
        model.addAttribute("todos", todos);
        return "todoController";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showAddNewTodoPage(ModelMap model) {
        String userName = getAuthenticatedUserName();
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
            String userName = getAuthenticatedUserName();
            List<Todo> todos = todoRepository.findByOwnerName(userName);
            todoService.addNewTodo(userName, todo.getDescription(), todo.getEndDate(), false);
            return "redirect:list-todos";
        }
    }

    @RequestMapping(value = "delete-todos", method = RequestMethod.GET)
    public String deleteTodos(@RequestParam int id)
    {
        todoService.deleteByID(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todos", method = RequestMethod.GET)
    public String showUpdateTodos(@RequestParam int id,ModelMap model)
    {
        Todo todo = todoService.findByID(id);
        model.addAttribute("todo",todo);
        return "AddTodo";
    }

    @RequestMapping(value = "update-todos", method = RequestMethod.POST)
    public String updateTodos(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "AddTodo";
        }
        else {
            String userName = getAuthenticatedUserName();
            List<Todo> todos = todoRepository.findByOwnerName(userName);
//            todos.remove(todo);
            todo.setOwnerName(userName);
            todoService.updateTodo(todo);
            return "redirect:list-todos";
        }
    }

    public String getAuthenticatedUserName()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
