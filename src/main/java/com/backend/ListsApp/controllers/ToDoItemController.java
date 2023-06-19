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
import com.backend.ListsApp.entities.TodoItem;
import com.backend.ListsApp.services.TodoItemService;

@RequestMapping("todoItem")
@RestController
public class TodoItemController {
	
	@Autowired
	private TodoItemService todoItemService;
	

	@GetMapping("/getAll")
	public List<TodoItem> getAllTodoItems() {
		return todoItemService.getAllToDoItems();
	}
	
	@PostMapping("/add")
	public void addTodoItem(@RequestBody TodoItem todo) {
		todoItemService.addTodoItem(todo);
	}
	
	@PutMapping("/update")
	public void updateToDoItem(@RequestBody TodoItem todo) {
		todoItemService.updateTodoItem(todo);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTodoItem(@PathVariable Long id) {
		todoItemService.deleteTodoItem(id);
	}
	
	@GetMapping("/getList/{id}") 
	public ItemList getTodoListByTodoItem(@PathVariable Long id) {
		return todoItemService.getTodoListByTodoItem(id);
	}
			
}
