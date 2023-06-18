package com.backend.ListsApp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ListsApp.entities.ListOfItems;
import com.backend.ListsApp.entities.Todo;
import com.backend.ListsApp.repositories.ListOfItemsRepository;
import com.backend.ListsApp.repositories.TodoRepository;

@Service
public class ListsAppService {
	@Autowired
	private ListOfItemsRepository listOfItemsRepository;
	@Autowired
	private TodoRepository todoRepository;
	
	// Service for ListOFItems
	public void createNewListOfItems(ListOfItems listOfItems) {
		listOfItemsRepository.save(listOfItems);
	}
	
	public List<ListOfItems> getAllListsOfItems() {
		return listOfItemsRepository.findAll();
	}
	
	public void deleteListOfItems(Long listId) {
		listOfItemsRepository.deleteById(listId);;
	}
	
	public void updateListOfItems(ListOfItems listOfItems) {
		listOfItemsRepository.save(listOfItems);
	}
	
	public ListOfItems getListOfItemsByTodoId(Long todoId) {
		Optional<Todo> optTodo = todoRepository.findById(todoId);
		if(optTodo.isPresent()) {
			return optTodo.get().getListOfItems();
		} else {
			return null;
		}
	}
	
	public Optional<ListOfItems> getListOfItemsById(Long listId) {
		return listOfItemsRepository.findById(listId);
	}
	 
	
	// Service for Todo
	public void createNewTodo(Todo todo) {
		todoRepository.save(todo);
	}
	
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}
	
	public void deleteTodo(Long todoId) {
		todoRepository.deleteById(todoId);
	}
	
	public void updateTodo(Todo todo) {
		todoRepository.save(todo);
	}
	
	public List<Todo> getTodosByListId(Long listId) {
		Optional<ListOfItems> optListOfItems = listOfItemsRepository.findById(listId);
		if(optListOfItems.isPresent()) {
			return optListOfItems.get().getTodos();
		} else {
			return new ArrayList<Todo>();
		}
	}
	
}
