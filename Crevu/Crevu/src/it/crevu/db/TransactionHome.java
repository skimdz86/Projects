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
 * Home object for domain model class Transaction.
 * @see it.crevu.db.Transaction
 * @author Hibernate Tools
 */
//@Stateless
@Component("TransactionDAO")
@Transactional
//@Repository
public class TransactionHome {

	private static final Log log = LogFactory.getLog(TransactionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Transaction transientInstance) {
		log.debug("persisting Transaction instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Transaction persistentInstance) {
		log.debug("removing Transaction instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Transaction merge(Transaction detachedInstance) {
		log.debug("merging Transaction instance");
		try {
			Transaction result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Transaction findById(TransactionId id) {
		log.debug("getting Transaction instance with id: " + id);
		try {
			Transaction instance = entityManager.find(Transaction.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
    public List<Transaction> loadTransactionByIdWarehouse(Integer idWarehouse){
        return entityManager.createQuery("from Transaction t where t.idWarehouse = :idWarehouse")
                .setParameter("idWarehouse", idWarehouse).getResultList();
    }
    
    public List<Transaction> loadTransactionByIdSupplierOrder(Integer idSupplierOrder){
    	return entityManager.createQuery("from Transaction t where t.idSupplierOrder = :idSupplierOrder")
            .setParameter("idSupplierOrder", idSupplierOrder).getResultList();
    }
}
