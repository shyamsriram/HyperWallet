package com.hyperwallet.rest.ws;
import java.lang.String;

public class ToDoTask {

	String Id;
	String Title;
	String Description;
	String Completed;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCompleted() {
		return Completed;
	}
	public void setCompleted(String completed) {
		Completed = completed;
	}
}
