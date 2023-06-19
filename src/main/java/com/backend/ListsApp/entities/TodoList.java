package com.backend.ListsApp.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class TodoList extends ItemList {
	
	@OneToMany(mappedBy="todoList")
	private List<TodoItem> todos;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User author;

	public TodoList() {
		super();
	}

	public List<TodoItem> getTodos() {
		return todos;
	}

	public void setTodos(List<TodoItem> todos) {
		this.todos = todos;
	}
}
