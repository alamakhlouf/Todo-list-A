package com.example.TodoList;

import com.example.TodoList.Service.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.example.TodoList.Service","com.example.TodoList.Controller",
		"com.example.TodoList.DAO","com.example.TodoList.Model" })
public class TodoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

}
