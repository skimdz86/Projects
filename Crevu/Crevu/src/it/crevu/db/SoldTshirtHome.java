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
 * Home object for domain model class SoldTshirt.
 * @see it.crevu.db.SoldTshirt
 * @author Hibernate Tools
 */
//@Stateless
@Component("SoldTshirtDAO")
@Transactional
//@Repository
public class SoldTshirtHome {

	private static final Log log = LogFactory.getLog(SoldTshirtHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(SoldTshirt transientInstance) {
		log.debug("persisting SoldTshirt instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(SoldTshirt persistentInstance) {
		log.debug("removing SoldTshirt instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public SoldTshirt merge(SoldTshirt detachedInstance) {
		log.debug("merging SoldTshirt instance");
		try {
			SoldTshirt result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SoldTshirt findById(SoldTshirtId id) {
		log.debug("getting SoldTshirt instance with id: " + id);
		try {
			SoldTshirt instance = entityManager.find(SoldTshirt.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
    
    
	

    public List<SoldTshirt> loadSoldTshirtByIdSeller(Integer idSeller) {
        return entityManager.createQuery("from SoldTshirt s where s.idSeller=:idSeller")
            .setParameter("idSeller", idSeller).getResultList();
    }

    public List<SoldTshirt> loadSoldTshirtByIdBuyer(Integer idBuyer) {
        return entityManager.createQuery("from SoldTshirt s where s.idBuyer=:idBuyer")
            .setParameter("idBuyer", idBuyer).getResultList();
    }
}
