package it.test.social;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.conf.Configuration;
import twitter4j.media.ImageUpload;
import twitter4j.media.ImageUploadFactory;
import twitter4j.media.MediaProvider;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwitterConnection4J {

 String ACCESSTOKEN = "1173193586-C4ODnaDLTClhAVF8YypW5MvHBz2ZTJ5ZcDWGtWI";
 String ACCESS_TOKEN_SECRET = "kCfB4QfdUpuvzGbAslyt0u1VquzoECDJw4DMk20Kg0";
	 
 
 	String consumerKey;
 	String consumerSecret;
 
	public TwitterConnection4J(String consumerKey, String consumerSecret) {
		super();
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
	
	public String preConnect() {

		String testStatus = "Hello from twitter4j";
		
		ConfigurationBuilder cb = new ConfigurationBuilder();

		// the following is set without accesstoken- desktop client
		cb.setDebugEnabled(true).setOAuthConsumerKey("VF4tvfddhO1LYtel0sEA")
				.setOAuthConsumerSecret("zejF9Z9ELL8fwtGa0MlYga9PwvGkbM8U3nmEJMwmgrM");

		try {
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();

			try {
				System.out.println("-----");

				// get request token.
				// this will throw IllegalStateException if access token is
				// already available
				// this is oob, desktop client version
				RequestToken requestToken = twitter.getOAuthRequestToken();

				System.out.println("Got request token.");
				System.out.println("Request token: " + requestToken.getToken());
				System.out.println("Request token secret: "
						+ requestToken.getTokenSecret());

				String oAuthVerifier = null;//mi ritorna con la callback come parametro
				System.out.println("|-----");

				AccessToken accessToken = null;//NON HA EXPIRY!!!
				//se proprio voglio fare verifica:
				/*You can also check in on the integrity of an access token at any time by calling the GET account/verify_credentials while using that access token.*/

				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));

					System.out
							.println("Open the following URL and grant access to your account:");
					System.out.println(requestToken.getAuthorizationURL());
				oAuthVerifier = br.readLine();
					try {
							accessToken = twitter
									.getOAuthAccessToken(requestToken, oAuthVerifier);
						
					} catch (TwitterException te) {
						if (401 == te.getStatusCode()) {
							System.out
									.println("Unable to get the access token.");
						} else {
							te.printStackTrace();
						}
					}
				System.out.println("Got access token.");
				System.out.println("Access token: " + accessToken.getToken());
				System.out.println("Access token secret: "
						+ accessToken.getTokenSecret());

			} catch (IllegalStateException ie) {
				// access token is already available, or consumer key/secret is
				// not set.
				if (!twitter.getAuthorization().isEnabled()) {
					System.out.println("OAuth consumer key/secret is not set.");
					System.exit(-1);
				}
			}

			Status status = twitter.updateStatus(testStatus);

			System.out.println("Successfully updated the status to ["
					+ status.getText() + "].");

			System.out.println("ready exit");

			System.exit(0);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get timeline: " + te.getMessage());
			System.exit(-1);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Failed to read the system input.");
			System.exit(-1);
		}
		
		return "";
	}
	
	
//	public AccessToken connect(String ){
//		
//	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwitterConnection4J conn = new TwitterConnection4J(null,null);
		conn.preConnect();
//conn.post();
		
	}







	private void post() {
		// TODO Auto-generated method stub
		ConfigurationBuilder cb = new ConfigurationBuilder();

		// the following is set without accesstoken- desktop client
		cb.setDebugEnabled(true).setOAuthConsumerKey("VF4tvfddhO1LYtel0sEA")
				.setOAuthConsumerSecret("zejF9Z9ELL8fwtGa0MlYga9PwvGkbM8U3nmEJMwmgrM");

		try {
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			AccessToken accessToken = new AccessToken(ACCESSTOKEN, ACCESS_TOKEN_SECRET);
			twitter.setOAuthAccessToken(accessToken);
			
			twitter.updateStatus("TEST123");
			
		}catch(Exception e){
			
		}
	}

}
