package com.backend.ListsApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ListsApp.entities.TodoItem;
import com.backend.ListsApp.entities.TodoList;
import com.backend.ListsApp.repositories.TodoItemRepository;

@Service
public class TodoItemService {
	
	@Autowired
	private TodoItemRepository todoItemRepository;
	
	
	public List<TodoItem> getAllToDoItems() {
		return todoItemRepository.findAll();
	}
	
	public void addTodoItem(TodoItem todo) {
		todoItemRepository.save(todo);
	}

	public void updateTodoItem(TodoItem todo) {
		todoItemRepository.save(todo);
	}
	
	public void deleteTodoItem(Long id) {
		todoItemRepository.deleteById(id);
	}
	
	// Find Todo List by Todo Items ID
	public TodoList getTodoListByTodoItem(Long id) {
		Optional<TodoItem> optTodo = todoItemRepository.findById(id);
		
		if(optTodo.isPresent()) {
			return optTodo.get().getTodoList();
		} else {
			return null;
		}
	}
}
