package net.planner.model;

import java.sql.Date;

public class Task {
	private int id_task;
	private String title;
	private String description;
	private Date due_date;
	private String priority;
	
	public Task(int id_task, String title, String description, Date due_date, String priority ) {
		this.id_task = id_task;
		this.title = title;
		this.description = description;
		this.due_date = due_date;
		this.priority = priority;
	}

	public int getId_task() {
		return id_task;
	}

	public void setId_task(int id_task) {
		this.id_task = id_task;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
}
