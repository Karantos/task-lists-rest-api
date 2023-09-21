package com.backend.ListsApp.entities;

import java.util.List;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints =
		{@UniqueConstraint(columnNames = "username"), @UniqueConstraint(columnNames = "email")})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	private String email;

	@OneToMany(mappedBy = "author")
	@JsonIgnore
	private List<TasksList> tasksList;
	
	@ManyToMany
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	public User() {

	}
	
	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Long getUserId() {
		return id;
	}

	public void setUserId(Long userId) {
		this.id = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<TasksList> getTasksList() {
		return tasksList;
	}

	public void setTodoLists(List<TasksList> tasksList) {
		this.tasksList = tasksList;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}	
}
