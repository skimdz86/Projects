
package it.crevu.fe.controller;


import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("recoverPwdController")
//@ManagedBean(name="recoverPwdController")
//@RequestScoped
//@SessionScoped
@Scope(value = "request")
public class RecoverPwdController extends BaseController{
//request scoped ricostruisce l'oggetto managedbean ad ogni chiamata; se è session/appllication tiene lo stato invece
	public static final String NAVIGATION_RULE = "/pages/help/forgot.jsf";
	
	private String username;
	private String password;
	
//	@PostConstruct
//	public void init(){
//	}
	
	public String recoverUsername(){
		
		//doRecover
		return "";
	}
	
	public String recoverPassword(){
		
		//doRecover
		return "";
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

	public static String getNavigationRule() {
		return NAVIGATION_RULE;
	}

	
		
}
