package it.crevu.fe.controller;


import it.crevu.databean.NotificationData;
import it.crevu.db.Notification;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("topBarController")
//@ManagedBean(name="topBarController")
//@RequestScoped
//@SessionScoped
@Scope(value = "request")
public class TopBarController extends BaseController{
//request scoped ricostruisce l'oggetto managedbean ad ogni chiamata; se è session/appllication tiene lo stato invece
	public static final String NAVIGATION_RULE = "/pages/index.jsf";
	
	private Integer notificationNumber;
	private ArrayList<NotificationData> notifications = new ArrayList<NotificationData>();
	
	
	@PostConstruct
	public void init(){
		
	}


	public Integer getNotificationNumber() {
		return notificationNumber;
	}


	public void setNotificationNumber(Integer notificationNumber) {
		this.notificationNumber = notificationNumber;
	}


	public ArrayList<NotificationData> getNotifications() {
		return notifications;
	}


	public void setNotifications(ArrayList<NotificationData> notifications) {
		this.notifications = notifications;
	}


	public static String getNavigationRule() {
		return NAVIGATION_RULE;
	}
	
	

	
		
}
