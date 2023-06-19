package com.backend.ListsApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.ListsApp.entities.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {
	
}
