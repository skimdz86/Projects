package it.crevu.rest.controller;

import it.crevu.core.interfaces.UserManager;
import it.crevu.databean.UserData;
import it.crevu.exception.UserNotFoundException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserService {

	@Inject
	UserManager userManager;
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public @ResponseBody UserData getUserProfile(@PathVariable String username){
//		UserData userData = new UserData();
//		User user = new User();
//		user.setUsername(username);
//		user.setId(1);
//		user.setUserType("admin");
//		userData.setUser(user);
		UserData userData = new UserData();
		try {
			userData = userManager.getUserProfile(username);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userData;
	}
}
