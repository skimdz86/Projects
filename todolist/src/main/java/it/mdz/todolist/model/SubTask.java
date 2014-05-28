package it.mdz.todolist.model;

import java.util.Date;
import java.util.List;

public class SubTask extends BaseBean {

	Integer order;
	String description;
	Boolean completed;
	Boolean outcome;
	Date creationDate;
	List<Comment> comments;
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
