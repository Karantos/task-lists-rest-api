package com.backend.ListsApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.ListsApp.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
