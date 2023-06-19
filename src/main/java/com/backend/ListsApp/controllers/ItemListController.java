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
import com.backend.ListsApp.services.ItemListService;


@RequestMapping("api/itemList")
@RestController
public class ItemListController {
	
	@Autowired
	private ItemListService itemListService;
	
	
	@GetMapping("")
	public List<ItemList> getAllItemLists() {
		return itemListService.getAllItemLists();
	}
	
	@PostMapping("")
	public void addItemList(@RequestBody ItemList list) {
		itemListService.addItemList(list);
	}
	
	@PutMapping("")
	public void updateItemList(@RequestBody ItemList list) {
		itemListService.updateItemList(list);
	}
	
	@DeleteMapping("/{id}")
	public void deleteItemList(@PathVariable Long id) {
		itemListService.deleteItemList(id);
	}
	
	@GetMapping("/getItemList/{id}")
	public ItemList getItemList(@PathVariable Long id) {
		return itemListService.getItemList(id);
	}

	@GetMapping("/getItemListById/{id}") 
	public List<ToDoItem> getTodoItemByItemListId(@PathVariable Long id) {
		return itemListService.getToDoItemByItemListId(id);
	}

}
