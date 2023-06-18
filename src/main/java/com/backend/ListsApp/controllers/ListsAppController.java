package com.backend.ListsApp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ListsApp.entities.ListOfItems;
import com.backend.ListsApp.entities.Todo;
import com.backend.ListsApp.services.ListsAppService;


@RestController
@RequestMapping("ListsApp")
public class ListsAppController {
	@Autowired
	private ListsAppService listsAppService;
	
	// Controller for ListOfItems
	@GetMapping("/getAllLists")
	public List<ListOfItems> getAllListsOfItems() {
		return listsAppService.getAllListsOfItems();
	}
	
	@PostMapping("/createList")
	public void createListOfItems(@RequestBody ListOfItems list) {
		listsAppService.createNewListOfItems(list);
	}
	
	@DeleteMapping("/deleteList/{listId}")
	public void deleteListOfItems(@PathVariable Long listId) {
		listsAppService.deleteListOfItems(listId);
	}
	
	@PutMapping("/updateList")
	public void updateListOfItems(@RequestBody ListOfItems list) {
		listsAppService.updateListOfItems(list);
	}
	
	@GetMapping("/getListByTodoId/{todoId}") 
	public ListOfItems getListOfItemsByTodoId(@PathVariable Long todoId) {
		return listsAppService.getListOfItemsByTodoId(todoId);
	}
	
	@GetMapping("/getListById/{listId}")
	public Optional<ListOfItems> getListById(@PathVariable Long listId) {
		return listsAppService.getListOfItemsById(listId);
	}
	
	// Controller for Todo
	@GetMapping("/getAllTodos")
	public List<Todo> getAllTodos() {
		return listsAppService.getAllTodos();
	}
	
	@PostMapping("/createTodo")
	public void createTodo(@RequestBody Todo todo) {
		listsAppService.createNewTodo(todo);
	}
	
	@DeleteMapping("/deleteTodo/{todoId}")
	public void deleteTodo(@PathVariable Long todoId) {
		listsAppService.deleteTodo(todoId);
	}
	
	@PutMapping("/updateTodo")
	public void updateTodo(@RequestBody Todo todo) {
		listsAppService.updateTodo(todo);
	}
			
	@GetMapping("/getTodosByListId/{listId}") 
	public List<Todo> getTodosByListId(@PathVariable Long listId) {
		return listsAppService.getTodosByListId(listId);
	}
}
