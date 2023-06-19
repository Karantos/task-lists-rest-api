package com.backend.ListsApp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ListsApp.entities.ItemList;
import com.backend.ListsApp.entities.ToDoItem;
import com.backend.ListsApp.repositories.ItemListRepository;

@Service
public class ItemListService {
	
	@Autowired
	private ItemListRepository itemListRepository;
	
	public List<ItemList> getAllItemLists() {
		return itemListRepository.findAll();
	}
	
	public void addItemList(ItemList itemList) {
		itemListRepository.save(itemList);
	}
	
	public void updateItemList(ItemList listOfItems) {
		itemListRepository.save(listOfItems);
	}
	
	public void deleteItemList(Long listId) {
		itemListRepository.deleteById(listId);;
	}

	public ItemList getItemList(Long listId) {
		Optional<ItemList> optItemList = itemListRepository.findById(listId);
		
		if(optItemList.isPresent()) {
			return optItemList.get();
		} else {
			return null;
		}
	}
	
	public List<ToDoItem> getToDoItemByItemListId(Long id) {
		Optional<ItemList> optListOfItems = itemListRepository.findById(id);
		
		if(optListOfItems.isPresent()) {
			return optListOfItems.get().getTodos();
		} else {
			return new ArrayList<ToDoItem>();
		}
	}
}
