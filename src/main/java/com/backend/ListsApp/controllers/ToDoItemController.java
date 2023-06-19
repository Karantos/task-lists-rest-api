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

import com.backend.ListsApp.entities.ItemList;
import com.backend.ListsApp.entities.ToDoItem;
import com.backend.ListsApp.services.ToDoItemService;

@RequestMapping("api/toDoItem")
@RestController
public class ToDoItemController {
	
	@Autowired
	private ToDoItemService toDoItemService;
	

	@GetMapping("/getAllTodos")
	public List<ToDoItem> getAllToDoItems() {
		return toDoItemService.getAllToDoItems();
	}
	
	@PostMapping("/createTodo")
	public void addToDoItem(@RequestBody ToDoItem todo) {
		toDoItemService.addToDoItem(todo);
	}
	
	@PutMapping("/updateTodo")
	public void updateToDoItem(@RequestBody ToDoItem todo) {
		toDoItemService.updateToDoItem(todo);
	}
	
	@DeleteMapping("/deleteTodo/{todoId}")
	public void deleteToDoItem(@PathVariable Long todoId) {
		toDoItemService.deleteToDoItem(todoId);
	}
	
	@GetMapping("/{todoId}") 
	public ItemList getItemListByToDoItem(@PathVariable Long todoId) {
		return toDoItemService.getItemListByToDoItem(todoId);
	}
			
}