package com.backend.ListsApp.entities;

import jakarta.persistence.Entity;

@Entity
public class Todo extends Item {
	private boolean isFinished;

	public Todo() {
		super();
	}

	public boolean getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
}
