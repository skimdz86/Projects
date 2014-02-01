package it.crevu.databean;


import it.crevu.db.User;
import it.crevu.db.Text;
import it.crevu.db.TextWish;

import java.util.List;

public class TextWishData extends DataObject{
	
	List<TextWish> textWishes;
	List<User> users;
	List<Text> texts;

	
	
	public List<TextWish> getTextWishes() {
		return textWishes;
	}
	public void setTextWishes(List<TextWish> textWishes) {
		this.textWishes = textWishes;
	}

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public List<Text> getText() {
		return texts;
	}
	public void setText(List<Text> texts) {
		this.texts = texts;
	}


}
