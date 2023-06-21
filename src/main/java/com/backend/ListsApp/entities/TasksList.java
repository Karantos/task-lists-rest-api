package com.backend.ListsApp.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class TasksList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Primary key that will be auto generated
	private Long listId;
	private String listName;
	
	@CreationTimestamp
	@JsonIgnore
	private LocalDateTime dateCreated;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User author;
	
	@OneToMany(mappedBy="tasksList")
	@JsonIgnore
	private List<Task> tasks;
	
	public TasksList() {
		super();
	}
	
	public Long getListId() {
		return listId;
	}
	
	public void setListId(Long id) {
		this.listId = id;
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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTodos(List<Task> tasks) {
		this.tasks = tasks;
	}
}
