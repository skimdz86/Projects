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
 * Home object for domain model class Revenue.
 * @see it.crevu.db.Revenue
 * @author Hibernate Tools
 */
//@Stateless
@Component("RevenueDAO")
@Transactional
//@Repository
public class RevenueHome {

	private static final Log log = LogFactory.getLog(RevenueHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Revenue transientInstance) {
		log.debug("persisting Revenue instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Revenue persistentInstance) {
		log.debug("removing Revenue instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Revenue merge(Revenue detachedInstance) {
		log.debug("merging Revenue instance");
		try {
			Revenue result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Revenue findById(RevenueId id) {
		log.debug("getting Revenue instance with id: " + id);
		try {
			Revenue instance = entityManager.find(Revenue.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<Revenue> loadRevenueByIdUser(Integer idUser) {
        return entityManager.createQuery("from Revenue r where r.idUser = :idUser")
            .setParameter("idUser", idUser).getResultList();
    }
	
	
	public List<Revenue> loadRevenueByIdSoldTshirt(Integer idSoldTshirt){
        return entityManager.createQuery("from Revenue r where r.idSoldTshirt = :idSoldTshirt")
                .setParameter("idSoldTshirt", idSoldTshirt).getResultList();
	}
	
}
