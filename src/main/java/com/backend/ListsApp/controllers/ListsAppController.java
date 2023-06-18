package com.backend.ListsApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ListsApp.entities.ListOfItems;
import com.backend.ListsApp.services.ListsAppService;


@RestController
@RequestMapping("ListsApp")
public class ListsAppController {
	@Autowired
	private ListsAppService listsAppService;
	
	@GetMapping("/getAllLists")
	public List<ListOfItems> getAllListsOfItems() {
		return listsAppService.getAllListsOfItems();
	}
	
	@PostMapping("/createList")
	public void createListOfItems(@RequestBody ListOfItems list) {
		listsAppService.createNewListOfItems(list);
	}
	
	@DeleteMapping("/deleteList/{listId}")
	public void deleteListOfItems(@PathVariable int listId) {
		listsAppService.deleteListOfItems(listId);
	}
}
