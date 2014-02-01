package it.crevu.fe.controller;


import it.crevu.dao.WelcomeUserDAO;
import it.crevu.db.WelcomeUser;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name="testController")
//@RequestScoped
//@SessionScoped
@Scope(value = "request")
public class TestController extends BaseController{
//request scoped ricostruisce l'oggetto managedbean ad ogni chiamata; se è session/appllication tiene lo stato invece
	public static final String NAVIGATION_RULE = "/pages/testPage.jsf";
	
	public String testValue;
	
	@ManagedProperty("#{WelcomeUserDAO}")
	private WelcomeUserDAO dao;
	
	@PostConstruct
	public void init(){
		
		//richiamo un bean spring, che richiama a sua volta hibernate
		
//		ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(FacesContext.getCurrentInstance());
//		BeanTest bean = (BeanTest)context.getBean(BeanTest.class);
//		
//		setTestValue(bean.getMessage());
		
		
		
		WelcomeUser user = dao.findById(2);
		
		setTestValue(user.getNickname());
		
//		UserHome home = new UserHome();
//		User res = home.findById(1);
//		if(res!=null && !res.getEmail().equals("")) setTestValue(res.getEmail());
//		else setTestValue("NOOOO!");
	}
	
	

	public String getTestValue() {
		return testValue;
	}

	public void setTestValue(String testValue) {
		this.testValue = testValue;
	}

	public void setDao(WelcomeUserDAO dao) {
		this.dao = dao;
	}

	public WelcomeUserDAO getDao() {
		return dao;
	}

	
		
}
