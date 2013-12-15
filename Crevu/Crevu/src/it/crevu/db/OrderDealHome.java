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
 * Home object for domain model class OrderDeal.
 * @see it.crevu.db.OrderDeal
 * @author Hibernate Tools
 */
//@Stateless
@Component("OrderedDealDAO")
@Transactional
//@Repository
public class OrderDealHome {

	private static final Log log = LogFactory.getLog(OrderDealHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(OrderDeal transientInstance) {
		log.debug("persisting OrderDeal instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(OrderDeal persistentInstance) {
		log.debug("removing OrderDeal instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public OrderDeal merge(OrderDeal detachedInstance) {
		log.debug("merging OrderDeal instance");
		try {
			OrderDeal result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OrderDeal findById(OrderDealId id) {
		log.debug("getting OrderDeal instance with id: " + id);
		try {
			OrderDeal instance = entityManager.find(OrderDeal.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<OrderDeal> loadOrderDealByIdSupplierOrder(Integer idSupplierOrder){
        return entityManager.createQuery("from OrderDeal o where o.idSupplierOrder = :idSupplierOrder")
                .setParameter("idSupplierOrder", idSupplierOrder).getResultList();
	}
	
	
}
