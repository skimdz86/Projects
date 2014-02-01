package it.crevu.db;

// Generated 20-apr-2013 15.10.16 by Hibernate Tools 3.6.0

import it.crevu.dao.UserTshirtRankingDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class UserTshirtRanking.
 * @see it.crevu.db.UserTshirtRanking
 * @author Hibernate Tools
 */
//@Stateless
@Component("UserTshirtRankingDAO")
@Transactional
public class UserTshirtRankingHome implements UserTshirtRankingDAO{

	private static final Log log = LogFactory
			.getLog(UserTshirtRankingHome.class);

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void persist(UserTshirtRanking transientInstance) {
		log.debug("persisting UserTshirtRanking instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UserTshirtRanking persistentInstance) {
		log.debug("removing UserTshirtRanking instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UserTshirtRanking merge(UserTshirtRanking detachedInstance) {
		log.debug("merging UserTshirtRanking instance");
		try {
			UserTshirtRanking result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserTshirtRanking findById(UserTshirtRankingId id) {
		log.debug("getting UserTshirtRanking instance with id: " + id);
		try {
			UserTshirtRanking instance = entityManager.find(
					UserTshirtRanking.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
