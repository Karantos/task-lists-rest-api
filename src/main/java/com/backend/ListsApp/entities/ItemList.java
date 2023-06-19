package com.backend.ListsApp.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ItemList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Primary key that will be auto generated
	private Long id;
	private String name;
	private LocalDateTime dateCreated;
	
	@OneToMany(mappedBy="itemList")
	private List<ToDoItem> todos;
	
	public ItemList() {
		super();
	}
	
	public Long getListId() {
		return id;
	}
	public void setListId(Long listId) {
		this.id = listId;
	}
	public String getListName() {
		return name;
	}
	public void setListName(String listName) {
		this.name = listName;
	}
	 
	public LocalDateTime getDateTime() {
		return dateCreated;
	}

	public void setDateTime(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<ToDoItem> getTodos() {
		return todos;
	}
	public void setTodos(List<ToDoItem> todos) {
		this.todos = todos;
	}
	
	
}
