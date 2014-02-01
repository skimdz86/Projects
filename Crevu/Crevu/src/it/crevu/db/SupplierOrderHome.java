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
 * Home object for domain model class SupplierOrder.
 * @see it.crevu.db.SupplierOrder
 * @author Hibernate Tools
 */
//@Stateless
@Component("SupplierOrderDAO")
@Transactional
//@Repository
public class SupplierOrderHome {

	private static final Log log = LogFactory.getLog(SupplierOrderHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(SupplierOrder transientInstance) {
		log.debug("persisting SupplierOrder instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(SupplierOrder persistentInstance) {
		log.debug("removing SupplierOrder instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public SupplierOrder merge(SupplierOrder detachedInstance) {
		log.debug("merging SupplierOrder instance");
		try {
			SupplierOrder result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SupplierOrder findById(SupplierOrderId id) {
		log.debug("getting SupplierOrder instance with id: " + id);
		try {
			SupplierOrder instance = entityManager
					.find(SupplierOrder.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	
	
	
	public List<SupplierOrder> loadSupplierOrderByIdOrderDeal(Integer idOrderDeal){
        return entityManager.createQuery("from SupplierOrder s where s.idOderDeal = :idOderDeal")
                .setParameter("idOderDeal", idOrderDeal).getResultList();
        }
    
	public List<SupplierOrder> loadSupplierOrderByIdWarehouse(Integer idWarehouse) {
        return entityManager.createQuery("from SupplierOrder s where s.idWarehouse = :idWarehouse")
                .setParameter("idWarehouse", idWarehouse).getResultList();
        }
}
