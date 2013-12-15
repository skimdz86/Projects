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
 * Home object for domain model class Category.
 * @see it.crevu.db.Category
 * @author Hibernate Tools
 */
//@Stateless
@Component("CategoryDAO")
@Transactional
//@Repository
public class CategoryHome {

	private static final Log log = LogFactory.getLog(CategoryHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Category transientInstance) {
		log.debug("persisting Category instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Category persistentInstance) {
		log.debug("removing Category instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Category merge(Category detachedInstance) {
		log.debug("merging Category instance");
		try {
			Category result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Category findById(Integer id) {
		log.debug("getting Category instance with id: " + id);
		try {
			Category instance = entityManager.find(Category.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	

	public List<Category> loadCategory() {
        return entityManager.createQuery("from Category c order by c.categoryName").getResultList();
    }
}
