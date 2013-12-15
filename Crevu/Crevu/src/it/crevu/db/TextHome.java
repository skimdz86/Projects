package it.crevu.db;

// Generated 26-mar-2013 21.12.17 by Hibernate Tools 3.6.0

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class Text.
 * @see it.crevu.db.Text
 * @author Hibernate Tools
 */
//@Stateless
@Component("TextDAO")
@Transactional
//@Repository
public class TextHome {

	private static final Log log = LogFactory.getLog(TextHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Text transientInstance) {
		log.debug("persisting Text instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Text persistentInstance) {
		log.debug("removing Text instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Text merge(Text detachedInstance) {
		log.debug("merging Text instance");
		try {
			Text result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Text findById(TextId id) {
		log.debug("getting Text instance with id: " + id);
		try {
			Text instance = entityManager.find(Text.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	


	public List<Text> loadText() {
        return entityManager.createQuery("from Text t order by votes desc").getResultList();
    }
}
