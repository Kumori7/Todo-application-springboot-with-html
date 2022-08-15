package com.ab.Entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "todo")
public class TodoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank
	@Column(name = "description")
	private String description;

	@NotBlank
	@Column(name = "category")
	private String category;

	@Column(name = "date_created")
	private String dateCreated;

	@Column(name = "task_status")
	private boolean taskStatus;

	public TodoItem() {
	}

	public TodoItem(int id, String description, String category, String dateCreated, boolean taskStatus) {
		this.id = id;
		this.description = description;
		this.category = category;
		this.dateCreated = dateCreated;
		this.taskStatus = taskStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(boolean taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Override
	public String toString() {
		return "TodoItem [id=" + id + ", description=" + description + ", category=" + category + ", dateCreated="
				+ dateCreated + ", taskStatus=" + taskStatus + "]";
	}
	
	

} // end of class
