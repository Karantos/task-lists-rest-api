package com.backend.ListsApp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ListsApp.entities.ItemList;
import com.backend.ListsApp.entities.TodoItem;
import com.backend.ListsApp.entities.TodoList;
import com.backend.ListsApp.repositories.TodoListRepository;

@Service
public class TodoListService {
	
	@Autowired
	private TodoListRepository todoListRepository;
	
	public List<TodoList> getAllTodoLists() {
		return todoListRepository.findAll();
	}
	
	public void addTodoList(TodoList list) {
		todoListRepository.save(list);
	}
	
	public void updateTodoList(TodoList list) {
		todoListRepository.save(list);
	}
	
	public void deleteTodoList(Long listId) {
		todoListRepository.deleteById(listId);;
	}

	public ItemList getTodoList(Long listId) {
		Optional<TodoList> optTodoList = todoListRepository.findById(listId);
		
		if(optTodoList.isPresent()) {
			return optTodoList.get();
		} else {
			return null;
		}
	}
	
	// Find Todo Item by Todo Lists ID
	public List<TodoItem> getTodoItemByTodoList(Long id) {
		Optional<TodoList> optTodoList = todoListRepository.findById(id);
		
		if(optTodoList.isPresent()) {
			return optTodoList.get().getTodos();
		} else {
			return new ArrayList<TodoItem>();
		}
	}
}
