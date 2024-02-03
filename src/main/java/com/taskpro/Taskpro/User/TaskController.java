package com.taskpro.Taskpro.User;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.taskpro.Taskpro.Service.TaskService;
import com.taskpro.Taskpro.Entity.Task;

@RestController
@RequestMapping("api/v1/task")

public class TaskController {
	private final TaskService taskService;
	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping()
	public List <Task> getTasks(){
		return taskService.getTasks();
	}
	@PostMapping(path= "/saveTask")
	public void RegisterNewTask(@RequestBody Task task) {
		taskService.addNewTasks(task);
	}
	
	@DeleteMapping(path= "{taskId}")
	public void DeleteTask(@PathVariable("taskId") Integer taskId) {
		taskService.deleteTask(taskId);
	}
	@PutMapping(path = "{taskId}")
    public void updateTask(@PathVariable("taskId") Integer taskId, @RequestBody Task updatedTask) {
        taskService.updateTask(taskId, updatedTask);
    }

}
