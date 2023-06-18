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
	protected Long itemId;
	protected String itemName;
	protected String itemDescription;
	@ManyToOne
	@JoinColumn(name="list_id")
	@JsonIgnore
	protected ListOfItems listOfItems;
	
	public Item() {
		super();
	}
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public ListOfItems getListOfItems() {
		return listOfItems;
	}
	public void setListOfItems(ListOfItems listOfItems) {
		this.listOfItems = listOfItems;
	}
	
	
}
