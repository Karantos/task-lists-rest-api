package com.backend.ListsApp.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class ItemList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Primary key that will be auto generated
	protected Long listId;
	protected String listName;
	
	@CreationTimestamp
	@JsonIgnore
	protected LocalDateTime dateCreated;
	
	public ItemList() {
		super();
	}
	
	public Long getListId() {
		return listId;
	}
	public void setListId(Long listId) {
		this.listId = listId;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	 
	public LocalDateTime getDateTime() {
		return dateCreated;
	}

	public void setDateTime(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
}
