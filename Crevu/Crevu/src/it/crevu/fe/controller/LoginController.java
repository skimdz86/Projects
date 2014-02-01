//
//package it.crevu.fe.controller;
//
//
//import it.crevu.core.interfaces.UserManager;
//
//import javax.annotation.PostConstruct;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//
//@Controller
//@ManagedBean(name="loginController")
////@RequestScoped
////@SessionScoped
//@Scope(value = "request")//FIXME: poi sarà session però mi sa!
//public class LoginController extends BaseController{
////request scoped ricostruisce l'oggetto managedbean ad ogni chiamata; se è session/appllication tiene lo stato invece
//	public static final String NAVIGATION_RULE = "/pages/index.jsf";
//	
//	private String username;
//	private String password;
//	
//	@ManagedProperty("#{userManager}")
//	UserManager userManager;
//
//	Boolean logged;
//	
//	//DA CAPIRE SE PUO SERVIRE A QUALCOSA STO CONTROLLER
//	
//	@PostConstruct
//	public void init(){
//	
//	}
//	
//
//
//
//
//	public static String getNavigationRule() {
//		return NAVIGATION_RULE;
//	}
//
//	
//		
//}
