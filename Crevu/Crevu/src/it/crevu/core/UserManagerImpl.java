package it.crevu.core;

import it.crevu.core.interfaces.UserManager;
import it.crevu.dao.AddressDAO;
import it.crevu.dao.PaymentDataDAO;
import it.crevu.dao.SocialAccountDAO;
import it.crevu.dao.UserDAO;
import it.crevu.databean.UserData;
import it.crevu.db.Address;
import it.crevu.db.PaymentData;
import it.crevu.db.SocialAccount;
import it.crevu.db.User;
import it.crevu.exception.UserNotFoundException;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component("userManager")
public class UserManagerImpl implements UserManager{

	@Inject
	UserDAO userDAO;
	
	@Inject
	AddressDAO addressDAO;
	
	@Inject
	SocialAccountDAO socialAccountDAO;
	
	@Inject
	PaymentDataDAO paymentDataDAO;
	
	public UserManagerImpl(){
		super();
	}
	
	@Override
	public UserData getUserProfile(String username) throws UserNotFoundException{
		
		UserData userData = new UserData();
		
		User user = userDAO.loadUserByUsername(username);
		
		List<SocialAccount> socialAccounts = socialAccountDAO.loadSocialAccountByIdUser(user.getId());
		
		List<Address> addresses = addressDAO.loadAddressByIdUser(user.getId());
		
		PaymentData paymentData = paymentDataDAO.loadPaymentDataByIdUser(user.getId());
		
		userData.setAddresses(addresses);
		userData.setPaymentData(paymentData);
		userData.setSocialAccounts(socialAccounts);
		userData.setUser(user);
		
		return userData;
	}

	@Override
	public void userSignup(User user) {
		user.setUserType("USER");//l'admin non verrà mai registrato da codice
		userDAO.persist(user);
	}

	@Override
	public Boolean login(String username, String password) {
		
		
		Boolean logged = userDAO.login(username, password);
		
		return logged;
	}

	@Override
	public Integer verifySocialRegisteredUser(String socialId, String accountType) {
		SocialAccount socialAccount = socialAccountDAO.getUserBySocialId(socialId, accountType);
		if(socialAccount!=null) return socialAccount.getIdUser();
		return null;
	}

	@Override
	public UserData getUserProfile(Integer idUser) throws UserNotFoundException {
		
		UserData userData = new UserData();
		
		User user = userDAO.findById(idUser);
		
		List<SocialAccount> socialAccounts = socialAccountDAO.loadSocialAccountByIdUser(user.getId());
		
		List<Address> addresses = addressDAO.loadAddressByIdUser(user.getId());
		
		PaymentData paymentData = paymentDataDAO.loadPaymentDataByIdUser(user.getId());
		
		userData.setAddresses(addresses);
		userData.setPaymentData(paymentData);
		userData.setSocialAccounts(socialAccounts);
		userData.setUser(user);
		
		return userData;
	}

	@Override
	public void registerSocialAccount(SocialAccount account) {
		socialAccountDAO.persist(account);
	}

	@Override
	public Boolean autoLogin(String user, String cookieSecret) {
		
		Boolean logged = userDAO.autoLogin(user, cookieSecret);
		
		return logged;
	}
	
}
