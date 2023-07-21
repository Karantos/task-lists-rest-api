package com.backend.ListsApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.backend.ListsApp.services.TasksListService;

@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("lists")
@RestController
public class TasksListController {
	
	@Autowired
	private TasksListService tasksListService;
	
	
	@GetMapping("/getAll")
	public List<TasksList> getAllTasksLists() {
		return tasksListService.getAllTasksLists();
	}
	
	@PostMapping("/add")
	public void addTasksList(@RequestBody TasksList list) {
		tasksListService.addTasksList(list);
	}
	
	@PutMapping("/update")
	public void updateTasksList(@RequestBody TasksList list) {
		tasksListService.updateTasksList(list);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTasksList(@PathVariable Long id) {
		tasksListService.deleteTasksList(id);
	}
	
	@GetMapping("/get/{id}")
	public TasksList getTasksList(@PathVariable Long id) {
		return tasksListService.getTasksList(id);
	}

	@GetMapping("/getTask/{id}") 
	public List<Task> getTaskByTasksList(@PathVariable Long id) {
		return tasksListService.getTaskByTasksList(id);
	}
}
