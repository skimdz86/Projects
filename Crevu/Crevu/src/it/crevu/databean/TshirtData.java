package it.crevu.databean;

import it.crevu.db.TshirtProposal;

public class TshirtData extends DataObject {

	private String message;
	private Integer likes;
	private Integer numBought;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	public Integer getNumBought() {
		return numBought;
	}
	public void setNumBought(Integer numBought) {
		this.numBought = numBought;
	}

	
}
