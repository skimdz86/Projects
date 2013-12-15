package it.crevu.rest.controller;

import it.crevu.core.SocialAccountUtils;
import it.crevu.core.interfaces.UserManager;
import it.crevu.databean.UserData;
import it.crevu.db.SocialAccount;
import it.crevu.db.User;
import it.crevu.exception.UserNotFoundException;
import it.crevu.fe.controller.UserController;
import it.crevu.log.Logger;
import it.crevu.social.twitter.TwitterMethods;
import it.crevu.social.twitter.auth.TwitterConnection;
import it.crevu.util.PasswordEncoder;

import java.util.Date;
import java.util.HashMap;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@Controller
@RequestMapping("/social")
@Scope(value = "session")
public class SocialRestController {

	private static final Logger log = Logger.getInstance(SocialRestController.class);
	
//	@Inject 
//	private Environment environment;
	
	private @Value("${twitter.app.consumerKey}") String twitterConsumerKey;
	private @Value("${twitter.app.consumerSecret}") String twitterConsumerSecret;
	
	@Inject
	private TwitterMethods twitterMethods;
	
	@Inject
	private UserManager userManager;
	
	@Inject
	UserController userController;
	
	@Inject
	SocialAccountUtils socialAccountUtils;
	
	TwitterConnection conn;
	RequestToken requestToken;
	
	private String testCookie(HttpServletResponse response){
		
		System.out.println(response);
		//set cookie
				double randomNumber = Math.random();
				String secretRandomId;
				try {
					secretRandomId = PasswordEncoder.encodePassword(""+randomNumber);
					System.out.println(secretRandomId);
					HashMap<String, Object> cookieParams = new HashMap<String, Object>();
					cookieParams.put("comment", "crevu username");
//					cookieParams.put("maxAge", -1);
//					cookieParams.put("secure", false);
//					FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("crevu_user", "userditest", cookieParams);
//					FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("crevu_secret", secretRandomId, cookieParams);
					
					response.addCookie(new Cookie("crevu_user", "userditest"));
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//end set cookie
				return "redirect:/pages/index.jsf";
				
	}
	
	@RequestMapping(value = "/twitter/connect", method = RequestMethod.GET)
	public String twitterConnect(HttpServletResponse response){
		
		//gestire qui: getSavedAccessToken
		//se c'è a posto, altrimenti vado avanti
		//poi una volta ottenuto il nuovo, chiamo saveAccessToken-> appena dopo TwitterConnection.connect
		//sono tutte funzioni in SocialAccountUtils
		
//		socialAccountUtils.getSavedAccessToken(socialId, "TWITTER");//ma il socialid...come faccio? devo usare dei cookie?
		//non mi torna, devo avere salvato in locale qualcosa di twitter e poterlo leggere dalla applicazione...chiedere a Dario
	
		
		return testCookie(response);
		
		/**
		initializeSocialConnection();
		
		if(requestToken == null) return "redirect:/pages/index.jsf";
		
		return authorizeTwitter();
		**/
	}
	
	public void initializeSocialConnection(){
		//come gestire l'utente loggato?devo pure salvare il token in relazione a quello...
		//immagino sarà salvato in sessione...
		conn = new TwitterConnection(twitterConsumerKey, twitterConsumerSecret);
		requestToken = conn.preConnect();
		
	}
	
	public String authorizeTwitter(){
		return "redirect:"+requestToken.getAuthorizationURL();
	}
	
	@RequestMapping(value = "/twitter/callback", method = RequestMethod.GET)
	public String twitterCallback(@RequestParam(value="oauth_token", required=true) String oauthToken, @RequestParam(value="oauth_verifier", required=true) String oauthVerifier){
		
		System.out.println("In callback");
		AccessToken accessToken = conn.connect(requestToken, oauthVerifier);
		
		if(accessToken!=null){
			//1-accedo a twitter per recuperare i dati utente
			System.out.println("TOKEN: "+accessToken.getToken());
			System.out.println("SECRET: "+accessToken.getTokenSecret());
			twitterMethods.initialize(accessToken.getToken(), accessToken.getTokenSecret());
			
			TwitterProfile userTwitterProfile = twitterMethods.getProfile();
			Long socialId = userTwitterProfile.getId();
			System.out.println("SOCIAL_ID: "+socialId);
			//2-controllo se esistono nel mio db, nel qual caso è già registrato lo user
			Integer idUser = userManager.verifySocialRegisteredUser(socialId+"", "TWITTER");
			if(idUser!=null) {
				System.out.println("Gia presente");
				UserData userData = null;
				try {
					userData = userManager.getUserProfile(idUser);
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				userController.setIsAuthenticated(true);
				userController.setUserData(userData);
				userController.setUser(userData.getUser());
				
				//FIXME: gestire se non riesco a recuperare userData....
			}
			else{
				//3-altrimenti lo registro
				System.out.println("Registro nuovo utente");
				User user = new User();
				user.setUsername(userTwitterProfile.getScreenName());
//				user.setFirstName(userTwitterProfile.getName());
//				user.setLastName(userTwitterProfile.getName());
				user.setCity(userTwitterProfile.getLocation());
				user.setPassword(" ");
				user.setEmail(" ");
//				user.setBirthDate(new Date());
//				user.setGender('N');
				user.setNationality(userTwitterProfile.getLanguage());//da rivedere
				userManager.userSignup(user);
				//più social signup, devo create una funzione
				UserData userData;
				try {
					userData = userManager.getUserProfile(userTwitterProfile.getScreenName());
					SocialAccount account = new SocialAccount();
					account.setIdUser(userData.getUser().getId());
					account.setSocialId(socialId+"");
					account.setDateChange(new Date());
					account.setDateCreate(new Date());
					account.setAccountType("TWITTER");
					account.setAccessTokenValue(accessToken.getToken());
					account.setAccessTokenSecret(accessToken.getTokenSecret());
					
					userManager.registerSocialAccount(account);
					
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
						FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("crevu_user", userData.getUser().getUsername(), cookieParams);
						FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("crevu_secret", secretRandomId, cookieParams);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//end set cookie
					
					
					//popolo il bean di sessione
					userController.setUserData(userData);
					userController.setUser(userData.getUser());
					userController.setIsAuthenticated(true);
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		//e poi come uscire da qui e ritornare alle mie pagine? forse usare facescontext
		
		return "redirect:/pages/index.jsf";//da controllare se va così o in che altro modo
	}
}
