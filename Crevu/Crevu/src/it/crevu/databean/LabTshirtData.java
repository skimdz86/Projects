package it.crevu.databean;

import java.util.Date;

public class LabTshirtData extends DataObject {

	private String message;
	private Date date;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
