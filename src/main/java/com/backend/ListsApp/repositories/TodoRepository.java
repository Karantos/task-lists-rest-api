package com.backend.ListsApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.ListsApp.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
