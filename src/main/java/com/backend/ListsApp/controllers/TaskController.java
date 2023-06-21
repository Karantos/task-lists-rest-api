package com.backend.ListsApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ListsApp.entities.Task;
import com.backend.ListsApp.entities.TasksList;
import com.backend.ListsApp.services.TaskService;

@RequestMapping("tasks")
@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	

	@GetMapping("/getAll")
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}
	
	@PostMapping("/add")
	public void addTask(@RequestBody Task task) {
		taskService.addTask(task);
	}
	
	@PutMapping("/update")
	public void updateTask(@RequestBody Task task) {
		taskService.updateTask(task);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
	}
	
	@GetMapping("/getTasksList/{id}") 
	public TasksList getTasksListtByTask(@PathVariable Long id) {
		return taskService.getTasksListByTask(id);
	}
			
}
