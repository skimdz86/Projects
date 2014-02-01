package it.crevu.db;

// Generated 26-mar-2013 21.12.17 by Hibernate Tools 3.6.0

import java.util.Collection;
import java.util.List;

import it.crevu.dao.WelcomeUserDAO;
import it.crevu.log.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class WelcomeUser.
 * @see it.crevu.db.WelcomeUser
 * @author Hibernate Tools
 */
//@Stateless
@Component("WelcomeUserDAO")
@Transactional
//@Repository
public class WelcomeUserHome implements WelcomeUserDAO{

	private static final Logger log = Logger.getInstance(WelcomeUserHome.class);

	private EntityManager entityManager;

	@PersistenceContext //(unitName = "crevuPersistenceUnit", type = PersistenceContextType.TRANSACTION)
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void persist(WelcomeUser transientInstance) {
		log.debug("persisting WelcomeUser instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(WelcomeUser persistentInstance) {
		log.debug("removing WelcomeUser instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public WelcomeUser merge(WelcomeUser detachedInstance) {
		log.debug("merging WelcomeUser instance");
		try {
			WelcomeUser result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	
	public WelcomeUser findById(Integer id) {
		log.debug("getting WelcomeUser instance with id: " + id);
		try {
			WelcomeUser instance = entityManager.find(WelcomeUser.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<WelcomeUser> loadWelcomeUserByNickname(String nickname) {
	       return entityManager.createQuery("from WelcomeUser w where w.nickname = :nickname")
	           .setParameter("nickname", nickname).getResultList();
	   }

		public List<WelcomeUser> loadWelcomeUserByEmail(String email) {
	       return entityManager.createQuery("from WelcomeUser w where w.nickname = :email")
	           .setParameter("email", email).getResultList();
	   }
}
