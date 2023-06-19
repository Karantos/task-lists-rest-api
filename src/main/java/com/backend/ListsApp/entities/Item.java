package com.backend.ListsApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Primary key that will be auto generated
	protected Long id;
	protected String title;
	protected String description;
	@ManyToOne
	@JoinColumn(name="list_id")
	@JsonIgnore
	protected ItemList itemList;
	
	public Item() {
		super();
	}
	
	public Long getItemId() {
		return id;
	}
	public void setItemId(Long itemId) {
		this.id = itemId;
	}
	public String getItemName() {
		return title;
	}
	public void setItemName(String itemName) {
		this.title = itemName;
	}
	public String getItemDescription() {
		return description;
	}
	public void setItemDescription(String itemDescription) {
		this.description = itemDescription;
	}
	public ItemList getListOfItems() {
		return itemList;
	}
	public void setListOfItems(ItemList itemList) {
		this.itemList = itemList;
	}
	
	
}
