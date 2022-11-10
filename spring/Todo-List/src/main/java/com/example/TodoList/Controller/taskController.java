package com.example.TodoList.Controller;

import com.example.TodoList.Model.Task;
import com.example.TodoList.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/tasks")
public class taskController {

    @Autowired
    private TaskService taskService ;

    @PostMapping("/task")
    public void putTask(@RequestBody Task task) {
        taskService.putOne(task);
    }

    @GetMapping("/AllTasks")
    public List<Task> getAll() {
        return    this.taskService.getAll() ;
    }
    @GetMapping("/id")
    public Task getTask(@PathVariable int id) {
        return  taskService.getById(id).orElse(null) ;
    }
    @DeleteMapping("/employee/{id}")
    public void deleteTask(@RequestBody Task task) {
        taskService.deleteTask(task);
    }
    @PutMapping("/task/add")
    public void updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
    }
}
