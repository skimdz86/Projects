package it.crevu.db;

// Generated 26-mar-2013 21.12.17 by Hibernate Tools 3.6.0

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class TshirtCategory.
 * @see it.crevu.db.TshirtCategory
 * @author Hibernate Tools
 */
//@Stateless
@Component("TshirtCategoryDAO")
@Transactional
//@Repository
public class TshirtCategoryHome {

	private static final Log log = LogFactory.getLog(TshirtCategoryHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TshirtCategory transientInstance) {
		log.debug("persisting TshirtCategory instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TshirtCategory persistentInstance) {
		log.debug("removing TshirtCategory instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TshirtCategory merge(TshirtCategory detachedInstance) {
		log.debug("merging TshirtCategory instance");
		try {
			TshirtCategory result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TshirtCategory findById(TshirtCategoryId id) {
		log.debug("getting TshirtCategory instance with id: " + id);
		try {
			TshirtCategory instance = entityManager.find(TshirtCategory.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<TshirtCategory> loadTshirtCategoryByIdCategory(Integer idCategory)
	{
    	return entityManager.createQuery("from TshirtCategory t where t.idCategory = :idCategory")
                .setParameter("idCategory", idCategory).getResultList();
	}
}
