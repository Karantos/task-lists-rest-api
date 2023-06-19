package com.backend.ListsApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.ListsApp.entities.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
