package it.crevu.core;

import it.crevu.dao.SocialAccountDAO;
import it.crevu.db.SocialAccount;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import twitter4j.auth.AccessToken;

@Component
public class SocialAccountUtils {

	private static final String ACCOUNT_TYPE_TWITTER = "TWITTER";
	
	@Inject
 	SocialAccountDAO socialAccountDAO;
	
	public void saveAccessToken(AccessToken accessToken, Integer userId) {
		socialAccountDAO.saveAccessToken(userId, ACCOUNT_TYPE_TWITTER, accessToken.getToken(), accessToken.getTokenSecret());
	}


	public AccessToken getSavedAccessToken(Integer userId){
		//chiamo il db
		//se questa ok, non faccio tutta la connessione
		AccessToken accessToken = null;
		SocialAccount account = socialAccountDAO.findByUserAndType(userId, ACCOUNT_TYPE_TWITTER);
		if(account!=null){
			if(account.getAccessTokenValue()!=null && account.getAccessTokenSecret()!=null){
				accessToken = new AccessToken(account.getAccessTokenValue(), account.getAccessTokenSecret());
			}
		}
		return accessToken;
	}
}
