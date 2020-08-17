package net.planner.model;

import java.sql.Date;

public class ImportantDate {
	private int id_date;
	private String title;
	private Date due_date;
	private String priority;
	
	public ImportantDate(int id_date, String title, Date due_date, String priority) {
		this.id_date = id_date;
		this.title = title;
		this.due_date = due_date;
		this.priority = priority;
	}

	public int getId_date() {
		return id_date;
	}

	public void setId_date(int id_date) {
		this.id_date = id_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
