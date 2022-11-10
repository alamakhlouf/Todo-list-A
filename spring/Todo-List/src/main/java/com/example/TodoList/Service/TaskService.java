package com.example.TodoList.Service;

import com.example.TodoList.Model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {

    public List<Task> getAll() ;
    public Optional<Task> getById(int id) ;
    public void putOne(Task task) ;
    public void updateTask(Task task) ;

    public void deleteTask(Task task) ;
}
