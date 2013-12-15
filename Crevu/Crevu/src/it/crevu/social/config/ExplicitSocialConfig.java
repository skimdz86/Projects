/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.crevu.social.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jpa.JpaTemplate;
import org.springframework.social.connect.jpa.JpaUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.facebook.web.DisconnectController;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

/**
 * Spring Social Configuration.
 * 
 * This configuration shows an explicit configuration of Spring Social beans, not using the simplied configuration options from Spring Social 1.1.
 * It will only be used when the "explicit" profile is active.
 * The simpler configuration using Spring Social 1.1 annotation is available in SocialConfig.java.
 * 
 * @author Craig Walls
 */
@Configuration
@Profile("explicit")
public class ExplicitSocialConfig {

	@Inject
	private Environment environment;

//	@Inject
//	private DataSource dataSource;

	@Inject
	private JpaTemplate socialUserDAO;
	
	@Bean
	@Scope(value="singleton", proxyMode=ScopedProxyMode.INTERFACES) 
	public ConnectionFactoryLocator connectionFactoryLocator() {
		ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
		registry.addConnectionFactory(new TwitterConnectionFactory(environment.getProperty("twitter.app.consumerKey"),
				environment.getProperty("twitter.app.consumerSecret")));
		registry.addConnectionFactory(new FacebookConnectionFactory(environment.getProperty("facebook.app.clientId"),
				environment.getProperty("facebook.app.clientSecret")));
		return registry;
	}

	@Bean
	@Scope(value="singleton", proxyMode=ScopedProxyMode.INTERFACES) 
	public UsersConnectionRepository usersConnectionRepository() {
		return new JpaUsersConnectionRepository(socialUserDAO, connectionFactoryLocator(), Encryptors.noOpText());
	}

	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)	
	public ConnectionRepository connectionRepository() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
		}
		//esempio da automateddeveloper.blogspot
//		ApplicationUser user = (ApplicationUser)authentication.getPrincipal();
//		return usersConnectionRepository().createConnectionRepository(String.valueOf(user.getAccountId));
		return usersConnectionRepository().createConnectionRepository(authentication.getName());
	}

	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)	
	public Facebook facebook() {
		Connection<Facebook> facebook = connectionRepository().findPrimaryConnection(Facebook.class);
		return facebook != null ? facebook.getApi() : new FacebookTemplate();
	}
	
	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)	
	public Twitter twitter() {
		Connection<Twitter> twitter = connectionRepository().findPrimaryConnection(Twitter.class);
		return twitter != null ? twitter.getApi() : new TwitterTemplate();
	}

	
	@Bean
	public ConnectController connectController() {
		ConnectController connectController = new ConnectController(connectionFactoryLocator(), connectionRepository());
//		connectController.addInterceptor(new PostToWallAfterConnectInterceptor());
//		connectController.addInterceptor(new TweetAfterConnectInterceptor());
		return connectController;
	}

	//richiede la security...
//	@Bean
//	public ProviderSignInController providerSignInController(RequestCache requestCache) {
//		return new ProviderSignInController(connectionFactoryLocator(), usersConnectionRepository(), new SimpleSignInAdapter(requestCache));
//	}
	
	
	@Bean
	public DisconnectController disconnectController() {
		return new DisconnectController(usersConnectionRepository(), environment.getProperty("facebook.app.clientSecret"));
	}

}
