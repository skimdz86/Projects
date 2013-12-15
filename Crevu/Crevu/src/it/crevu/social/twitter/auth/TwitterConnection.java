package it.crevu.social.twitter.auth;

import it.crevu.dao.SocialAccountDAO;
import it.crevu.db.SocialAccount;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConnection {

//	private static final String ACCOUNT_TYPE_TWITTER = "TWITTER";
	
 String ACCESSTOKEN = "1173193586-C4ODnaDLTClhAVF8YypW5MvHBz2ZTJ5ZcDWGtWI";
 String ACCESS_TOKEN_SECRET = "kCfB4QfdUpuvzGbAslyt0u1VquzoECDJw4DMk20Kg0";
	 
// 	@Inject
// 	SocialAccountDAO socialAccountDAO;
 
 	String consumerKey;
 	String consumerSecret;
// 	Integer userId;
 
 	Twitter twitter;
 	
	public TwitterConnection(String consumerKey, String consumerSecret) {
		super();
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
//		this.userId = userId;
		
		ConfigurationBuilder cb = new ConfigurationBuilder();

		// the following is set without accesstoken- desktop client
		cb.setDebugEnabled(true)     //DA TOGLIERE
		.setOAuthConsumerKey(consumerKey)
		.setOAuthConsumerSecret(consumerSecret);

		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();

	}
	
	
	public RequestToken preConnect() {

		RequestToken requestToken = null;
		try {
			
			try {
				// get request token.
				// this will throw IllegalStateException if access token is
				// already available
				// this is oob, desktop client version
				requestToken = twitter.getOAuthRequestToken();

				System.out.println("Got request token.");
				System.out.println("Request token: " + requestToken.getToken());
				System.out.println("Request token secret: "
						+ requestToken.getTokenSecret());
				
			} catch (IllegalStateException ie) {
				// access token is already available, or consumer key/secret is
				// not set.
				if (!twitter.getAuthorization().isEnabled()) {
					System.out.println("OAuth consumer key/secret is not set.");
				}
			}

		} catch (TwitterException te) {
			te.printStackTrace();
		}
		
		return requestToken;
		
	}
	
	
	public AccessToken connect(RequestToken requestToken, String oauthVerifier) {

		AccessToken accessToken = null;// NON HA EXPIRY!!!
		// se proprio voglio fare verifica:
		/*
		 * You can also check in on the integrity of an access token at any time
		 * by calling the GET account/verify_credentials while using that access
		 * token.
		 */

		try {
			accessToken = twitter.getOAuthAccessToken(requestToken,	oauthVerifier);

		} catch (TwitterException te) {
			if (401 == te.getStatusCode()) {
				System.out.println("Unable to get the access token.");
			} else {
				te.printStackTrace();
			}
		}
		System.out.println("Got access token.");
		System.out.println("Access token: " + accessToken.getToken());
		System.out.println("Access token secret: "
				+ accessToken.getTokenSecret());

//		saveAccessToken(accessToken);
		
		return accessToken;
	}	
	
	
/*	public void saveAccessToken(AccessToken accessToken) {
		socialAccountDAO.saveAccessToken(this.userId, ACCOUNT_TYPE_TWITTER, accessToken.getToken(), accessToken.getTokenSecret());
	}


	public AccessToken getSavedAccessToken(){
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
	
*/
	
//	private void post() {
//		// TODO Auto-generated method stub
//		ConfigurationBuilder cb = new ConfigurationBuilder();
//
//		// the following is set without accesstoken- desktop client
//		cb.setDebugEnabled(true).setOAuthConsumerKey("VF4tvfddhO1LYtel0sEA")
//				.setOAuthConsumerSecret("zejF9Z9ELL8fwtGa0MlYga9PwvGkbM8U3nmEJMwmgrM");
//
//		try {
//			TwitterFactory tf = new TwitterFactory(cb.build());
//			Twitter twitter = tf.getInstance();
//			AccessToken accessToken = new AccessToken(ACCESSTOKEN, ACCESS_TOKEN_SECRET);
//			twitter.setOAuthAccessToken(accessToken);
//			
//			twitter.updateStatus("TEST123");
//			
//		}catch(Exception e){
//			
//		}
//	}

}
