package it.crevu.databean;

import it.crevu.db.Address;
import it.crevu.db.PaymentData;
import it.crevu.db.SocialAccount;
import it.crevu.db.User;

import java.util.List;

public class UserData extends DataObject {

	List<Address> addresses;
	PaymentData paymentData;
	List<SocialAccount> socialAccounts;
	User user;
	
	
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public PaymentData getPaymentData() {
		return paymentData;
	}
	public void setPaymentData(PaymentData paymentData) {
		this.paymentData = paymentData;
	}
	public List<SocialAccount> getSocialAccounts() {
		return socialAccounts;
	}
	public void setSocialAccounts(List<SocialAccount> socialAccounts) {
		this.socialAccounts = socialAccounts;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
