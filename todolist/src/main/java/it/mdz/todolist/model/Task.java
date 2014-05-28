package it.mdz.todolist.model;

import java.util.Date;
import java.util.List;

public class Task extends BaseBean {

	String userid;
	String title;
	String description;
	Long number;
	Date creationDate;
	Date dateLimit;
	Boolean completed;
	Boolean outcome;
	List<SubTask> subtasks;
	List<Comment> comments;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getDateLimit() {
		return dateLimit;
	}
	public void setDateLimit(Date dateLimit) {
		this.dateLimit = dateLimit;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public Boolean getOutcome() {
		return outcome;
	}
	public void setOutcome(Boolean outcome) {
		this.outcome = outcome;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	
	public List<SubTask> getSubtasks() {
		return subtasks;
	}
	public void setSubtasks(List<SubTask> subtasks) {
		this.subtasks = subtasks;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
