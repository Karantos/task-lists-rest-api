package com.backend.ListsApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.ListsApp.entities.TasksList;

public interface TasksListRepository extends JpaRepository<TasksList, Long> {
	
}
