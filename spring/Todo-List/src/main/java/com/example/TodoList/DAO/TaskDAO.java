package com.example.TodoList.DAO;

import com.example.TodoList.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDAO extends JpaRepository<Task, Integer> {
}
