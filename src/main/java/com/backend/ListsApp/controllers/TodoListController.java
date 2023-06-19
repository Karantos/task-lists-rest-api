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
import com.backend.ListsApp.entities.TodoList;
import com.backend.ListsApp.services.TodoListService;


@RequestMapping("todoList")
@RestController
public class TodoListController {
	
	@Autowired
	private TodoListService todoListService;
	
	
	@GetMapping("/getAll")
	public List<TodoList> getAllTodoLists() {
		return todoListService.getAllTodoLists();
	}
	
	@PostMapping("/add")
	public void addTodoList(@RequestBody TodoList list) {
		todoListService.addTodoList(list);
	}
	
	@PutMapping("/update")
	public void updateTodoList(@RequestBody TodoList list) {
		todoListService.updateTodoList(list);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTodoList(@PathVariable Long id) {
		todoListService.deleteTodoList(id);
	}
	
	@GetMapping("/get/{id}")
	public ItemList getTodoList(@PathVariable Long id) {
		return todoListService.getTodoList(id);
	}

	@GetMapping("/getTodo/{id}") 
	public List<TodoItem> getTodoItemByTodoLIst(@PathVariable Long id) {
		return todoListService.getTodoItemByTodoList(id);
	}
}
