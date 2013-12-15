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
 * Home object for domain model class OrderedTshirt.
 * @see it.crevu.db.OrderedTshirt
 * @author Hibernate Tools
 */
//@Stateless
@Component("OrderedTshirtDAO")
@Transactional
//@Repository
public class OrderedTshirtHome {

	private static final Log log = LogFactory.getLog(OrderedTshirtHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(OrderedTshirt transientInstance) {
		log.debug("persisting OrderedTshirt instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(OrderedTshirt persistentInstance) {
		log.debug("removing OrderedTshirt instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public OrderedTshirt merge(OrderedTshirt detachedInstance) {
		log.debug("merging OrderedTshirt instance");
		try {
			OrderedTshirt result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OrderedTshirt findById(OrderedTshirtId id) {
		log.debug("getting OrderedTshirt instance with id: " + id);
		try {
			OrderedTshirt instance = entityManager
					.find(OrderedTshirt.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	
	public List<OrderedTshirt> loadOrderedTshirtByIdOrderDeal(Integer idOrderDeal){
        return entityManager.createQuery("from OrderedTshirt o where o.idOrderDeal = :idOrderDeal")
                .setParameter("idOrderDeal", idOrderDeal).getResultList();
	}
	
	public List<OrderedTshirt> loadOrderedTshirtByIdSoldTshirt(Integer idSoldTshirt){
        return entityManager.createQuery("from OrderedTshirt o where o.idSoldTshirt = :idSoldTshirt")
                .setParameter("idSoldTshirt", idSoldTshirt).getResultList();
	}
	
}
