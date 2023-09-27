package com.backend.ListsApp.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.ListsApp.entities.User;
import com.backend.ListsApp.repositories.UserRepository;

// Loads the user information from the database using loadUserByUsername() method in UserDetailsServiceImpl class.
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username) // Finds the user in db.
			.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username)); // Throws exception if user not found.
			
		return UserDetailsImpl.build(user); // Creates a user details object from the user with UserDetailsImpl build method.
	}
}
