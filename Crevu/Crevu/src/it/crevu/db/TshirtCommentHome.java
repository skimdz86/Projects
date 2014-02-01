package it.crevu.db;

// Generated 20-apr-2013 15.10.16 by Hibernate Tools 3.6.0

import it.crevu.dao.TshirtCommentDAO;
import it.crevu.log.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class TshirtComment.
 * @see it.crevu.db.TshirtComment
 * @author Hibernate Tools
 */
//@Stateless
@Component("TshirtCommentDAO")
@Transactional
public class TshirtCommentHome implements TshirtCommentDAO{

	private static final Logger log = Logger.getInstance(TshirtCommentHome.class);

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void persist(TshirtComment transientInstance) {
		log.debug("persisting TshirtComment instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TshirtComment persistentInstance) {
		log.debug("removing TshirtComment instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TshirtComment merge(TshirtComment detachedInstance) {
		log.debug("merging TshirtComment instance");
		try {
			TshirtComment result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TshirtComment findById(Integer id) {
		log.debug("getting TshirtComment instance with id: " + id);
		try {
			TshirtComment instance = entityManager
					.find(TshirtComment.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
