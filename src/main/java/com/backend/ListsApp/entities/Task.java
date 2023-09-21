package com.backend.ListsApp.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Primary key that will be auto generated
	private Long id;
	private String taskTitle;	
	
	@CreationTimestamp
	@JsonIgnore
	private LocalDate taskCreated;
	
	@UpdateTimestamp
	@JsonIgnore
	private LocalDate taskUpdated;
	
	private LocalDate taskDueOn;
	
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name="list_id")
	private TasksList tasksList;
	
	public Task() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long taskId) {
		this.id = taskId;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public LocalDate getTaskCreated() {
		return taskCreated;
	}

	public void setTaskCreated(LocalDate taskCreated) {
		this.taskCreated = taskCreated;
	}

	public LocalDate getTaskUpdated() {
		return taskUpdated;
	}

	public void setTaskUpdated(LocalDate taskUpdated) {
		this.taskUpdated = taskUpdated;
	}

	public LocalDate getTaskDueOn() {
		return taskDueOn;
	}

	public void setTaskDueOn(LocalDate taskDueOn) {
		this.taskDueOn = taskDueOn;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public TasksList getTasksList() {
		return tasksList;
	}

	public void setTasksList(TasksList tasksList) {
		this.tasksList = tasksList;
	}
}
