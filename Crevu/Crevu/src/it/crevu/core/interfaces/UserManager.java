package it.crevu.core.interfaces;

import it.crevu.databean.UserData;
import it.crevu.db.SocialAccount;
import it.crevu.db.User;
import it.crevu.exception.UserNotFoundException;

public interface UserManager {

	public UserData getUserProfile(String username) throws UserNotFoundException;
	
	public UserData getUserProfile(Integer idUser) throws UserNotFoundException;
	
	public void userSignup(User user);
	
	public Boolean login(String username, String password);
	
	public Integer verifySocialRegisteredUser(String socialId, String accountType);
	
	public void registerSocialAccount(SocialAccount account);
	
	public Boolean autoLogin(String user, String cookieSecret);
}
