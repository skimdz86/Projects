package it.crevu.social.facebook;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.PagingParameters;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class FacebookMethods {

	@Inject
	FacebookConnectionFactory facebookFactory;
	
	private Facebook facebook;
	private String facebookUserId;
	
	private static final int LIMIT_POSTS = 100;

	public FacebookMethods() {
		super();
	}
	
	
	public void initialize(String accessToken){
		AccessGrant accessGrant = new AccessGrant(accessToken);
		Connection<Facebook> conn = facebookFactory.createConnection(accessGrant);
		facebook = conn.getApi();
		
		facebookUserId = facebook.userOperations().getUserProfile().getId();
	}
	
	public FacebookProfile getProfile(){
		return facebook.userOperations().getUserProfile();
	}
	
	/*RICHIEDE PERMESSI status_update, e forse publish_actions*/
	public String post(String text){
		return facebook.feedOperations().updateStatus(text);
	}
	
	//TODO: da testare
	/*RICHIEDE PERMESSI photo_upload*/
	public String postPhoto(String text, byte[] photo){
		
		Resource res = new ByteArrayResource(photo);
		
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		parts.set("source", res);
		parts.set("message", text);
		return facebook.publish(facebookUserId, "photos", parts);
		
	}
	
	public List<Post> getLatestPosts(int limit){
		List<Post> latestPosts = new ArrayList<Post>();
		PagingParameters params = new PagingParameters(limit,0,null,null);
		while(latestPosts.size()<limit){
			PagedList<Post> latest = facebook.feedOperations().getFeed(params);//da capire come gestire un ciclo per tirarne fuori sempre qualcuno, senza gravare su prestazioni
			for(Post p: latest){
				if(p.getMessage()!=null) {
					latestPosts.add(p);
					if(latestPosts.size()==limit) break;
				}
			}
			params = latest.getNextPage();
			params = new PagingParameters(limit, params.getOffset(), params.getSince(), params.getUntil());
		}
		return latestPosts;
	}
	
	/*RICHIEDE PERMESSI read_stream*/
	public List<Post> getRelevantPosts(int limit, int likeThreshold){
		List<Post> relevantPosts = new ArrayList<Post>();
		List<Post> latestPosts = getLatestPosts(LIMIT_POSTS);
		for(Post p: latestPosts){
			if(p.getLikeCount()>=likeThreshold && p.getMessage().length()<=140) {
				relevantPosts.add(p);
				if(relevantPosts.size()==limit) break;
			}
		}
		return relevantPosts;
	}
}
