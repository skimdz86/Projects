package it.crevu.db;

// Generated 26-mar-2013 21.12.17 by Hibernate Tools 3.6.0

import it.crevu.dao.UserDAO;
import it.crevu.exception.UserNotFoundException;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class User.
 * @see it.crevu.db.User
 * @author Hibernate Tools
 */
//@Stateless
@Component("UserDAO")
@Transactional
//@Repository
public class UserHome implements UserDAO{

	private static final Log log = LogFactory.getLog(UserHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(User transientInstance) {
		log.debug("persisting User instance");
		
		/*Aggiungo i default, altrimenti solleva eccezione*/
		transientInstance.setIsCompany(false);
		transientInstance.setBirdLevel("PLUME");
		transientInstance.setUserLevel("BRONZE");
		transientInstance.setDateCreate(new Date());
		transientInstance.setDateChange(new Date());
		
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(User persistentInstance) {
		log.debug("removing User instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public User findById(Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = entityManager.find(User.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public User loadUserByUsername(String username) throws UserNotFoundException {
        List<User> users = entityManager.createQuery("from User u where u.username = :username")
            .setParameter("username", username).getResultList();
        if(users.size()==1) return users.get(0);
        else throw new UserNotFoundException("User not found");
    }

	public List<User> loadUserByEmail(String email) {
        return entityManager.createQuery("from User u where u.email = :email")
            .setParameter("email", email).getResultList();
    }

	public List<User> loadUserByNationality(String nationality) {
        return entityManager.createQuery("from User u where u.nationality = :nationality order by u.email")
        		.setParameter("nationality", nationality).getResultList();
	}

	@Override
	public Boolean login(String username,  String password) {
		List res = entityManager.createQuery("from User u where u.username = :username and u.password=:password")
        .setParameter("username", username).setParameter("password", password).getResultList();
		
		if(res.size()==1) return true;
		return false;
	}

	@Override
	public Boolean autoLogin(String user, String cookieSecret) {
		List res = entityManager.createQuery("from User u where u.username = :username and u.cookieSecret=:cookieSecret")
		        .setParameter("username", user).setParameter("cookieSecret", cookieSecret).getResultList();
				
				if(res.size()==1) return true;
				return false;
	}
}
