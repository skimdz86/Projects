package it.test;

import it.crevu.fe.controller.BaseController;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="massyController")
@RequestScoped
//@SessionScoped
public class TestMassiController extends BaseController{
//request scoped ricostruisce l'oggetto managedbean ad ogni chiamata; se è session/appllication tiene lo stato invece
	public static final String NAVIGATION_RULE = "/pages/test.jsf";
	
	public String name;
	public String surname;
	public String complete_name;
	
	public String getComplete_name() {
		return complete_name;
	}

	public void setComplete_name(String complete_name) {
		this.complete_name = complete_name;
	}

	@PostConstruct
	public void init(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void action()
	{
		setComplete_name(name+surname);
	}
	
		
}
