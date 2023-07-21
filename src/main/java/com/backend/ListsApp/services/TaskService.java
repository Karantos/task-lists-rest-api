package com.backend.ListsApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ListsApp.entities.Task;
import com.backend.ListsApp.entities.TasksList;
import com.backend.ListsApp.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	
	public void addTask(Task task) {
		taskRepository.save(task);
	}

	public void updateTask(Task task) {
		taskRepository.save(task);
	}
	
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
	
	public void updateStatus(Task task) {
		taskRepository.save(task);
	}
	
	public Task getTask(Long taskId) {
		Optional<Task> optTask = taskRepository.findById(taskId);
		
		if(optTask.isPresent()) {
			return optTask.get();
		} else {
			return null;
		}
	}
	
	// Find Tasks List by Task ID
	public TasksList getTasksListByTask(Long id) {
		Optional<Task> optTask = taskRepository.findById(id);
		
		if(optTask.isPresent()) {
			return optTask.get().getTasksList();
		} else {
			return null;
		}
	}
}
