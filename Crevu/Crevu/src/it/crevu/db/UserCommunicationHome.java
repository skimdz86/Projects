package it.crevu.db;

// Generated 20-apr-2013 15.10.16 by Hibernate Tools 3.6.0

import it.crevu.dao.UserCommunicationDAO;
import it.crevu.log.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class UserCommunication.
 * @see it.crevu.db.UserCommunication
 * @author Hibernate Tools
 */
//@Stateless
@Component("UserCommunicationDAO")
@Transactional
public class UserCommunicationHome implements UserCommunicationDAO{

	private static final Logger log = Logger.getInstance(UserCommunicationHome.class);

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void persist(UserCommunication transientInstance) {
		log.debug("persisting UserCommunication instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UserCommunication persistentInstance) {
		log.debug("removing UserCommunication instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UserCommunication merge(UserCommunication detachedInstance) {
		log.debug("merging UserCommunication instance");
		try {
			UserCommunication result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserCommunication findById(Integer id) {
		log.debug("getting UserCommunication instance with id: " + id);
		try {
			UserCommunication instance = entityManager.find(
					UserCommunication.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
