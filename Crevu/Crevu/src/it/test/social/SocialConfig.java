package it.test.social;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

@Configuration
public class SocialConfig {
	
	String fbId = "XXXXXXXXXXXXXXX";
	String fbSecret = "XXXXXXXXXXXXXXXXXXXXx";
	String twId = "XXXXXXXXXXXXXXXXXXXXX";
	String twSecret = "XXXXXXXXXXXXXXXXXXXXXXX";
	
    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new FacebookConnectionFactory(
            fbId,
            fbSecret));
        registry.addConnectionFactory(new TwitterConnectionFactory(
                twId,
                twSecret));
        return registry;
    }

}
