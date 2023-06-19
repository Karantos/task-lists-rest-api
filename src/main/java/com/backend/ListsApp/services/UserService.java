package com.backend.ListsApp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ListsApp.entities.TodoList;
import com.backend.ListsApp.entities.User;
import com.backend.ListsApp.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);;
	}
	
	// Find users by their ID
	public User getUser(Long userId) {
		Optional<User> optUser = userRepository.findById(userId);
		
		if(optUser.isPresent()) {
			return optUser.get();
		} else {
			return null;
		}
	}
	
	// Find Todo List by User ID
	public List<TodoList> getTodoListByUser(Long userId) {
		Optional<User> optUser = userRepository.findById(userId);
		
		if(optUser.isPresent()) {
			return optUser.get().getTodoLists();
		} else {
			return new ArrayList<TodoList>();
		}
	}
}
