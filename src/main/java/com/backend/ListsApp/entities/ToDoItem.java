package com.backend.ListsApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TodoItem extends Item {
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name="list_id")
	@JsonIgnore
	private TodoList todoList;


	public TodoItem() {
		super();
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public TodoList getTodoList() {
		return todoList;
	}

	public void setTodoList(TodoList todoList) {
		this.todoList = todoList;
	}
}
