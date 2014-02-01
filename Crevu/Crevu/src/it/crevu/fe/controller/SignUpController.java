
package it.crevu.fe.controller;


import it.crevu.core.interfaces.UserManager;
import it.crevu.db.User;
import it.crevu.util.PasswordEncoder;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("signupController")
//@ManagedBean(name="signupController") //se si lascia anche @ManagedBean non viene inizializzato dal contesto di Spring e non funziona la Inject
//@RequestScoped
//@SessionScoped
@Scope(value = "request")//FIXME: poi sarà session però mi sa!
public class SignUpController extends BaseController{
//request scoped ricostruisce l'oggetto managedbean ad ogni chiamata; se è session/appllication tiene lo stato invece
	public static final String NAVIGATION_RULE = "/pages/help/signup.jsf";
	
	private User user;
	private String cfrPassword;

//	@ManagedProperty("#{userManager}")
	@Inject
	UserManager userManager;
	
	@Autowired
	UserController userController;
	
	@PostConstruct
	public void init(){
		System.out.println("INIT");
		user = new User();
	}
	
	public String save(){
		System.out.println("SONO DENTRO");
		if(user.getUsername()!=null){ 
			//FIXME: trucco perchè ora non c'è il campo nazione
			getUser().setNationality("ITALY");
			userManager.userSignup(getUser());
			
			//set cookie
			double randomNumber = Math.random();
			String secretRandomId;
			try {
				secretRandomId = PasswordEncoder.encodePassword(""+randomNumber);
				System.out.println(secretRandomId);
				HashMap<String, Object> cookieParams = new HashMap<String, Object>();
				cookieParams.put("comment", "crevu username");
				cookieParams.put("maxAge", -1);
				cookieParams.put("secure", false);
				FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("crevu_user", getUser().getUsername(), cookieParams);
				FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("crevu_secret", secretRandomId, cookieParams);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//e intanto fai l'autenticazione però
			userController.setUsername(getUser().getUsername());
			userController.setPassword(getUser().getPassword());
			userController.login();
		}
		return "/pages/index.jsf";
	}
	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}


	public String getCfrPassword() {
		return cfrPassword;
	}

	public void setCfrPassword(String cfrPassword) {
		this.cfrPassword = cfrPassword;
	}

	public static String getNavigationRule() {
		return NAVIGATION_RULE;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	
		
}
