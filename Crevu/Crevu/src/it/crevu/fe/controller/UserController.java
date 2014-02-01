
package it.crevu.fe.controller;


import it.crevu.core.interfaces.UserManager;
import it.crevu.databean.LabTshirtData;
import it.crevu.databean.TshirtData;
import it.crevu.databean.UserData;
import it.crevu.db.User;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("userController")
//@ManagedBean(name="userController")
//@RequestScoped
//@SessionScoped
@Scope(value = "session")//FIXME: poi sarà session però, sicuramente!
public class UserController extends BaseController{
//request scoped ricostruisce l'oggetto managedbean ad ogni chiamata; se è session/appllication tiene lo stato invece
	public static final String NAVIGATION_RULE = "/pages/userProfile.jsf";
	
	//FORSE AL POSTO DI LOGIN CONTROLLER MEGLIO USARE QUESTO
	
	private String username;
	private String password;
	
	private boolean isAuthenticated;
	
	private User user;
	private UserData userData;
	private ArrayList<LabTshirtData> labTshirts = new ArrayList<LabTshirtData>();
	private ArrayList<TshirtData> myTshirts = new ArrayList<TshirtData>();
	
//	@ManagedProperty("#{userManager}")
	@Inject
	UserManager userManager;

	@PostConstruct
	public void init(){
		
		if(!isAuthenticated){
			//gestiamo cookie e auto login, solo in caso non ci sia gia una sessione
			Map<String, Object> cookieMap = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
			Object userCookie = cookieMap.get("crevu_user");
			Object secretCookie = cookieMap.get("crevu_secret");
			System.out.println((String)userCookie);
			System.out.println((String)secretCookie);
			isAuthenticated = userManager.autoLogin((String)userCookie, (String)secretCookie);
			
		}
		
		if(isAuthenticated){
			initializeUser();
		}
	}
	
	
	private void initializeUser(){
		try {
			user = userManager.getUserProfile(username).getUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public String login(){
		System.out.println("LOGIN");
		if(username!=null && password!=null){
			isAuthenticated = userManager.login(username, password);
			if(isAuthenticated) initializeUser();
		}
		return "/pages/index.jsf";
	}

	
	public String logout(){
		System.out.println("LOGOUT");
		isAuthenticated=false;
		user = new User();
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/pages/index.jsf?faces-redirect=true";
	}
	
	
	public boolean getIsAuthenticated() {
		return isAuthenticated;
	}


	public void setIsAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public ArrayList<LabTshirtData> getLabTshirts() {
		return labTshirts;
	}


	public void setLabTshirts(ArrayList<LabTshirtData> labTshirts) {
		this.labTshirts = labTshirts;
	}


	public ArrayList<TshirtData> getMyTshirts() {
		return myTshirts;
	}


	public void setMyTshirts(ArrayList<TshirtData> myTshirts) {
		this.myTshirts = myTshirts;
	}
	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	public UserData getUserData() {
		return userData;
	}


	public void setUserData(UserData userData) {
		this.userData = userData;
	}


	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}



	public static String getNavigationRule() {
		return NAVIGATION_RULE;
	}

	
		
}
