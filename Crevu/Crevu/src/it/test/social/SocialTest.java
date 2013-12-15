package it.test.social;

import it.crevu.social.facebook.FacebookMethods;
import it.crevu.social.twitter.TwitterMethods;
import it.test.BaseTest;

import java.util.List;

import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth1.OAuthToken;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.twitter.api.ListOperations;
import org.springframework.social.twitter.api.TimelineOperations;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

public class SocialTest extends BaseTest{

	
	public static void main(String[] args){
		
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("../applicationContext.xml");
		
//		SocialConfig config = new SocialConfig();
//		ConnectionFactoryLocator registry = config.connectionFactoryLocator();
//		
//		registry.getConnectionFactory(arg0)

		SocialTest test = new SocialTest();
//		test.testTweet();
//		test.testFB();
		test.testTwitter2();
//		test.testFB2();
	}
	
	private void testFB2() {
		// TODO Auto-generated method stub
		FacebookMethods met = (FacebookMethods)ctx.getBean(FacebookMethods.class);
//		TwitterMethods met = new TwitterMethods("1173193586-2j5ghkQyAKyK8IREQ5Gn0i7xhcAYvoR8wxnWGWI", "JUUIjgBWWx65kisotwJpHTOBkBurTtGOnMFVYcDGOk");
		met.initialize("BAACEdEose0cBAOz3FPb5NFksZCVJxV6zt6CRUMNehNi5WIJJjK35ZAN3LFevzTkRrQo15ZCUmXOnHCUbtpNZA1Y5MIsk05dcSXK78bm1Cm8h4uzKfmnPTOuMuqwIZA0sZD");
		List<Post> asd = met.getLatestPosts(10);
		FacebookProfile iuehfwi = met.getProfile();
		String post = met.post("test11");
		System.out.println();
	}

	public void testFB(){
		FacebookConnectionFactory fbFactory = (FacebookConnectionFactory)ctx.getBean("facebookConnectionFactory");
		//OAuthToken token = new OAuthToken("1173193586-2j5ghkQyAKyK8IREQ5Gn0i7xhcAYvoR8wxnWGWI", "JUUIjgBWWx65kisotwJpHTOBkBurTtGOnMFVYcDGOk");
		
		AccessGrant accessGrant = new AccessGrant("AAACEt8X9KJQBALnPWrQPI7tZAxhIZAYmfwHIk2WMI3ZBrIZBjYupT0S8EnR5IG5B7fHmOihRdTlIM2Am88ToFjCyvFQ2BHvQZAU69nWhJCkzwO6Evbf5q");
		Connection<Facebook> conn = fbFactory.createConnection(accessGrant);
		
		Facebook fb = conn.getApi();
		FacebookProfile profile = fb.userOperations().getUserProfile();
		List<Post> res = fb.feedOperations().getFeed();
		System.out.println();
	}
	
	public void testTweet(){
		TwitterConnectionFactory twitterFactory = (TwitterConnectionFactory)ctx.getBean("twitterConnectionFactory");
		OAuthToken token = new OAuthToken("1173193586-2j5ghkQyAKyK8IREQ5Gn0i7xhcAYvoR8wxnWGWI", "JUUIjgBWWx65kisotwJpHTOBkBurTtGOnMFVYcDGOk");		
		Connection<Twitter> conn = twitterFactory.createConnection(token);
		
		Twitter twitter = conn.getApi();
		
		
		
		ListOperations list = twitter.listOperations();
		TimelineOperations timelineOps = twitter.timelineOperations();
		
	    List<Tweet> results = timelineOps.getUserTimeline("beppe_grillo", 100);
	    System.out.println();

	}
	
	public void testTwitter2(){
		TwitterMethods met = (TwitterMethods)ctx.getBean(TwitterMethods.class);
//		TwitterMethods met = new TwitterMethods("1173193586-2j5ghkQyAKyK8IREQ5Gn0i7xhcAYvoR8wxnWGWI", "JUUIjgBWWx65kisotwJpHTOBkBurTtGOnMFVYcDGOk");
		met.initialize("1173193586-C4ODnaDLTClhAVF8YypW5MvHBz2ZTJ5ZcDWGtWI", "kCfB4QfdUpuvzGbAslyt0u1VquzoECDJw4DMk20Kg0");
//		List<Tweet> asd = met.getLatestTweets(100);
		TwitterProfile iuehfwi = met.getProfile();
//		Tweet asdddd = met.tweet("test11");
		System.out.println();
	}
}
