package it.crevu.social.old;
//
//import org.springframework.security.crypto.encrypt.TextEncryptor;
//import org.springframework.social.connect.ConnectionFactoryLocator;
//import org.springframework.social.connect.ConnectionRepository;
//
//public class SocialUserConnectionRepositoryImpl implements ConnectionRepository {
//
//	  private String userId;
//	  private SocialUserDAO socialUserDAO;
//	  private ConnectionFactoryLocator connectionFactoryLocator;
//	  private TextEncryptor textEncryptor;
//
//	  public SocialUserConnectionRepositoryImpl(String userId, SocialUserDAO socialUserDAO,
//	                                            ConnectionFactoryLocator connectionFactoryLocator,
//	                                            TextEncryptor textEncryptor) {
//	    this.userId = userId;
//	    this.socialUserDAO = socialUserDAO;
//	    this.connectionFactoryLocator = connectionFactoryLocator;
//	    this.textEncryptor = textEncryptor;
//	  }
//}