package com.backend.ListsApp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ListsApp.entities.Task;
import com.backend.ListsApp.entities.TasksList;
import com.backend.ListsApp.repositories.TaskRepository;
import com.backend.ListsApp.repositories.TasksListRepository;

@Service
public class TasksListService {
	
	@Autowired
	private TasksListRepository tasksListRepository;
	@Autowired
	private TaskRepository taskRepository;
	
	public List<TasksList> getAllTasksLists() {
		return tasksListRepository.findAll();
	}
	
	public void addTasksList(TasksList list) {
		tasksListRepository.save(list);
	}
	
	public void updateTasksList(TasksList list) {
		tasksListRepository.save(list);
	}
	
	public void deleteTasksList(Long listId) {
		List<Task> tasksToDel = getTaskByTasksList(listId);
		for (Task task : tasksToDel) {
			taskRepository.delete(task);
		}
		tasksListRepository.deleteById(listId);
	}

	public TasksList getTasksList(Long listId) {
		Optional<TasksList> optTasksList = tasksListRepository.findById(listId);
		
		if(optTasksList.isPresent()) {
			return optTasksList.get();
		} else {
			return null;
		}
	}
	
	// Find Task by Tasks List ID
	public List<Task> getTaskByTasksList(Long id) {
		Optional<TasksList> optTasksList = tasksListRepository.findById(id);
		
		if(optTasksList.isPresent()) {
			return optTasksList.get().getTasks();
		} else {
			return new ArrayList<Task>();
		}
	}
}
