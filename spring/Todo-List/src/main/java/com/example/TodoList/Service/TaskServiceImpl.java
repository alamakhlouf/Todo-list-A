package com.example.TodoList.Service;

import com.example.TodoList.DAO.TaskDAO;
import com.example.TodoList.Model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

   @Autowired
    TaskDAO taskDAO ;

    @Transactional
    @Override
    public List<Task> getAll() {
       return taskDAO.findAll();
    }



    @Transactional
    @Override
    public Optional<Task> getById(int id) {
        return taskDAO.findById(id) ;
    }
    @Transactional
    @Override
    public void putOne(Task task) {
        taskDAO.save(task) ;
    }

    @Override
    public void updateTask(Task task) {
        Task t = taskDAO.findById(task.getId()).orElse(null);
        System.out.println(t) ;
        if (t != null) {
            t.setId(task.getId());
            t.setTaskDescription(task.getTaskDescription());
            t.setTaskName(task.getTaskName());
            taskDAO.save(t) ;
        }
    }

    @Override
    public void deleteTask(Task task) {
        taskDAO.delete(task);
        }


}
