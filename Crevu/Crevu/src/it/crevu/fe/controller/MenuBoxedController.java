package it.crevu.fe.controller;


import it.crevu.databean.NotificationData;
import it.crevu.db.Notification;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("menuBoxedController")
//@ManagedBean(name="menuBoxedController")
//@RequestScoped
//@SessionScoped
@Scope(value = "request")
public class MenuBoxedController extends BaseController{
//request scoped ricostruisce l'oggetto managedbean ad ogni chiamata; se è session/appllication tiene lo stato invece
	public static final String NAVIGATION_RULE = "/pages/index.jsf";
	
	
	@PostConstruct
	public void init(){
		
	}


	public String goToCash(){
		//do something, popola il profilo con il cash...se serve e non è già in sessione
		return "/pages/userprofile/cash.xhtml";
	}
	
	public String goToLab(){
		//do something, popola il profilo con il cash...se serve e non è già in sessione
		return "/pages/userprofile/lab.xhtml";
	}
	
	public String goToMyTshirts(){
		//do something, popola il profilo con il cash...se serve e non è già in sessione
		return "/pages/userprofile/my_tshirts.xhtml";
	}
	
	public String goToAdminSection(){
		//do something, popola il profilo con il cash...se serve e non è già in sessione
		return "/pages/userprofile/admin.xhtml";
	}

	public static String getNavigationRule() {
		return NAVIGATION_RULE;
	}
	
	

	
		
}
