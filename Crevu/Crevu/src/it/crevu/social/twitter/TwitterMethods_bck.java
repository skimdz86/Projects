package it.crevu.social.twitter;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.oauth1.OAuthToken;
import org.springframework.social.twitter.api.TimelineOperations;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.stereotype.Component;

@Component
public class TwitterMethods_bck {

	@Inject
	private TwitterConnectionFactory twitterFactory;
	
	private Twitter twitter;
	private String twitterUsername;
	
	private static final int LIMIT_TIMELINE = 100;
	
	public TwitterMethods_bck(){
		super();
	}
	
	public void initialize(String value, String secret){
		
		OAuthToken accessToken = new OAuthToken(value, secret);
		Connection<Twitter> conn = twitterFactory.createConnection(accessToken);
		twitter = conn.getApi();
		
		twitterUsername = twitter.userOperations().getScreenName();
	}
	
	public List<Tweet> getLatestTweets(int limit){
		
		List<Tweet> tweets = new ArrayList<Tweet>();
		TimelineOperations timeline = twitter.timelineOperations();
		tweets = timeline.getUserTimeline(twitterUsername, limit);
		
		return tweets;
	}
	
	public TwitterProfile getProfile(){
		return twitter.userOperations().getUserProfile();
	}
	
	public Tweet tweet(String text){
		return twitter.timelineOperations().updateStatus(text);
	}
	
	//TODO: da testare
	public Tweet tweetWithPhoto(String text, byte[] photo){
		Resource res = new ByteArrayResource(photo);
		return twitter.timelineOperations().updateStatus(text, res);
	}
	
	public List<Tweet> getRelevantTweets(int limit, int retweetThreshold){
		
		List<Tweet> relevantTweets = new ArrayList<Tweet>();//limito a quanti?5?
		List<Tweet> latestTweets = getLatestTweets(LIMIT_TIMELINE);
		
		for(Tweet t: latestTweets){
			if(t.getRetweetCount()>=retweetThreshold && t.getText().length()<=140) {
				relevantTweets.add(t);
				if(relevantTweets.size()==limit) break;//limito il numero di suggerimenti ricavati
			}
		}
		
		return relevantTweets;
	}
}
