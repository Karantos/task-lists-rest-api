package com.backend.ListsApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ListsApp.entities.ListOfItems;
import com.backend.ListsApp.repositories.ListOfItemsRepository;
import com.backend.ListsApp.repositories.TodoRepository;

@Service
public class ListsAppService {
	@Autowired
	private ListOfItemsRepository listOfItemsRepository;
	@Autowired
	private TodoRepository todoRepository;
	
	public ListOfItems createNewListOfItems(ListOfItems listOfItems) {
		return listOfItemsRepository.save(listOfItems);
	}
	
	public List<ListOfItems> getAllListsOfItems() {
		return listOfItemsRepository.findAll();
	}
	
	public void deleteListOfItems(int listId) {
		listOfItemsRepository.deleteById(listId);
	}
	
}
