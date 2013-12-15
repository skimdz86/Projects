package it.test.social;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

@Configuration
public class SocialConfig {
	
	String fbId = "145924835584148";
	String fbSecret = "598bc53141d4e0bfab0ce3ff050c3ecb";
	String twId = "VF4tvfddhO1LYtel0sEA";
	String twSecret = "zejF9Z9ELL8fwtGa0MlYga9PwvGkbM8U3nmEJMwmgrM";
	
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
