package com.backend.ListsApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ListsApp.entities.ItemList;
import com.backend.ListsApp.entities.ToDoItem;
import com.backend.ListsApp.repositories.ToDoItemRepository;

@Service
public class ToDoItemService {
	
	@Autowired
	private ToDoItemRepository toDoItemRepository;
	
	
	public List<ToDoItem> getAllToDoItems() {
		return toDoItemRepository.findAll();
	}
	
	public void addToDoItem(ToDoItem todo) {
		toDoItemRepository.save(todo);
	}

	public void updateToDoItem(ToDoItem todo) {
		toDoItemRepository.save(todo);
	}
	
	public void deleteToDoItem(Long id) {
		toDoItemRepository.deleteById(id);
	}
	
	public ItemList getItemListByToDoItem(Long id) {
		Optional<ToDoItem> optTodo = toDoItemRepository.findById(id);
		
		if(optTodo.isPresent()) {
			return optTodo.get().getListOfItems();
		} else {
			return null;
		}
	}
}
