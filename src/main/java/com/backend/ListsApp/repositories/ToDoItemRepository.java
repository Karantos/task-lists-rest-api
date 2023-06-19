package com.backend.ListsApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.ListsApp.entities.ToDoItem;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {

}
