package com.backend.ListsApp.entities;

import jakarta.persistence.Entity;

@Entity
public class ToDoItem extends Item {
	private boolean status;

	public ToDoItem() {
		super();
	}

	public boolean getIsFinished() {
		return status;
	}

	public void setIsFinished(boolean status) {
		this.status = status;
	}
}
