
package it.crevu.fe.controller;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("tshirtController")
//@ManagedBean(name="tshirtController")
//@RequestScoped
//@SessionScoped
@Scope(value = "request")
public class TshirtController extends BaseController{
//request scoped ricostruisce l'oggetto managedbean ad ogni chiamata; se è session/appllication tiene lo stato invece
	public static final String NAVIGATION_RULE = "/pages/create_tshirt.jsf";
	
	private String statusType;
	private String text;
	private String hiddenTags;
	private String tags;
	
	@PostConstruct
	public void init(){
	}
	
//	public String createTshirt(){
//		return 
//	}
	
	public String saveToLab(){
	
		return "";
	}
	
	public String goLive(){
		
		return "";
	}
	
	
	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHiddenTags() {
		return hiddenTags;
	}

	public void setHiddenTags(String hiddenTags) {
		this.hiddenTags = hiddenTags;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public static String getNavigationRule() {
		return NAVIGATION_RULE;
	}

	
		
}
