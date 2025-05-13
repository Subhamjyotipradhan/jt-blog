package com.todo.todo_app.conroller;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.todo_app.model.Todo;

@Controller
public class TodoController {
    private List<Todo> todos;
    private static int idCounter;

    public TodoController(List<Todo> todos){
        this.todos = todos;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String task, Model model){
        if(!task.isEmpty() && !task.isBlank()){
        Todo todo = new Todo();
        todo.setId(++idCounter);
        todo.setTask(task);
        
        for (Todo existingTodo : todos) {
            if (existingTodo.getTask().equals(task)) {
                return "redirect:/";
            }
        }
            todos.add(todo);
        }
        return "redirect:/";
    }

    @GetMapping("/toggle/{id}")
    public String toggleTodo(@PathVariable int id){
        for (Todo todo : todos){
            if (todo.getId() == id) {
                todo.setCompleted(!todo.isCompleted());
            }
        }
        return "redirect:/";
    }

    // @GetMapping("/get-value/{x}")
    // public void printValue(PrintWriter pw, @PathVariable int x){
    //     pw.println("value extracted ");
    // }
    
    @GetMapping("/delete/{id}")
    public String deleteTodo(PrintWriter printWriter , @PathVariable int id ){
        for (Todo todo : todos){
            if (todo.getId() == id) {
                todos.remove(todo);
                break;
            }
        }
        return "redirect:/";
    }
}