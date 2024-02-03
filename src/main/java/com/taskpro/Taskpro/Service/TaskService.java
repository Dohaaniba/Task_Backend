package com.taskpro.Taskpro.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskpro.Taskpro.Entity.Task;
import com.taskpro.Taskpro.Repo.TaskRepository;



@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<Task> getTasks() {
		 return taskRepository.findAll();
    }
	
	public void addNewTasks( Task task) {
		Optional<Task> taskOptional = taskRepository.findByTitle(task.getTitle());
		
		if(taskOptional.isPresent()) {
			throw new IllegalStateException("title taken ");
		}
		taskRepository.save(task);
	}

	public void deleteTask(Integer taskId) {
		boolean existes = taskRepository.existsById( taskId);
		if(!existes) {
			throw new IllegalStateException("task with id"  + taskId + "does not existes" );
		}
		taskRepository.deleteById(taskId);
		
	}

	 public void updateTask(Integer taskId, Task updatedTask) {
	        // Vérifiez si la tâche existe
	        boolean exists = taskRepository.existsById(taskId);
	        if (!exists) {
	            throw new IllegalStateException("Task with id " + taskId + " does not exist");
	        }

	        // Mettez à jour les informations de la tâche
	        Task existingTask = taskRepository.findById(taskId).orElseThrow();
	        existingTask.setTitle(updatedTask.getTitle());
	        existingTask.setDescription(updatedTask.getDescription());
	        existingTask.setStatus(updatedTask.getStatus());
	        existingTask.setCreatedAt(updatedTask.getCreatedAt());
	        existingTask.setDueDate(updatedTask.getDueDate());

	        // Enregistrez la mise à jour
	        taskRepository.save(existingTask);
	    }

}
