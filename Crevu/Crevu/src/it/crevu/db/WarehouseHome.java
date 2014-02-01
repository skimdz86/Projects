package it.crevu.db;

// Generated 26-mar-2013 21.12.17 by Hibernate Tools 3.6.0

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class Warehouse.
 * @see it.crevu.db.Warehouse
 * @author Hibernate Tools
 */
//@Stateless
@Component("WarehouseDAO")
@Transactional
//@Repository
public class WarehouseHome {

	private static final Log log = LogFactory.getLog(WarehouseHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	
	 @PersistenceContext
	    public void setEntityManager(EntityManager entityManager) {
	        this. entityManager = entityManager;
	    }

	


	public void persist(Warehouse transientInstance) {
		log.debug("persisting Warehouse instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Warehouse persistentInstance) {
		log.debug("removing Warehouse instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Warehouse merge(Warehouse detachedInstance) {
		log.debug("merging Warehouse instance");
		try {
			Warehouse result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Warehouse findById(Integer id) {
		log.debug("getting Warehouse instance with id: " + id);
		try {
			Warehouse instance = entityManager.find(Warehouse.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
