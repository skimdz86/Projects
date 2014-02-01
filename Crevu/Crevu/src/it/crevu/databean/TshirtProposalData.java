package it.crevu.databean;

import it.crevu.db.Text;
import it.crevu.db.TshirtProposal;
import it.crevu.db.User;

import java.util.List;


public class TshirtProposalData extends DataObject{
	
	List<TshirtProposal> tshirtProposals;
	//perchè tutte ste liste???????????????????????????????????????cosa mi rappresentano?
	List<User> users;
	List<Text> texts;
	public List<TshirtProposal> getTshirtProposals() {
		return tshirtProposals;
	}
	public void setTshirtProposals(List<TshirtProposal> tshirtProposals) {
		this.tshirtProposals = tshirtProposals;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Text> getTexts() {
		return texts;
	}
	public void setTexts(List<Text> texts) {
		this.texts = texts;
	}

}
