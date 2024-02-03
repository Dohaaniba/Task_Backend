package com.taskpro.Taskpro.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taskpro.Taskpro.Entity.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tasks")

public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String title;
	private String description;
	private Status status;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX", shape = JsonFormat.Shape.STRING)
	private LocalDate createdAt;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX", shape = JsonFormat.Shape.STRING)
	private LocalDate dueDate; // la date ou la tache doit etre terminé 
	
	
	public Task() {}
	public Task(Integer id,String title, String description, Status status, LocalDate createdAt, LocalDate dueDate) {
		this.id= id;
		this.title= title;
		this.description= description;
		this.createdAt=  createdAt;
		this.status= status;
		this.dueDate = dueDate;
	}
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Status  getStatus() {
		return status;
	}
	public void setStatus(Status  status) {
		this.status = status;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
	public String ToString() {
		return "User { "
				+ "id" +id +
				" , title" + title +
				" ,description" + description +
				" ,status " + status +
				" createdAt " + createdAt +
				" dueDate " + dueDate +
				"}"
				
				
				;
		
	}

}
