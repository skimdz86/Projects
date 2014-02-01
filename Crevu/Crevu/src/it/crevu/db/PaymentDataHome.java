package it.crevu.db;

// Generated 26-mar-2013 21.12.17 by Hibernate Tools 3.6.0

import it.crevu.dao.PaymentDataDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class PaymentData.
 * @see it.crevu.db.PaymentData
 * @author Hibernate Tools
 */
//@Stateless
@Component("PaymentDataDAO")
@Transactional
//@Repository
public class PaymentDataHome implements PaymentDataDAO{

	private static final Log log = LogFactory.getLog(PaymentDataHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(PaymentData transientInstance) {
		log.debug("persisting PaymentData instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(PaymentData persistentInstance) {
		log.debug("removing PaymentData instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public PaymentData merge(PaymentData detachedInstance) {
		log.debug("merging PaymentData instance");
		try {
			PaymentData result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PaymentData findById(Integer id) {
		log.debug("getting PaymentData instance with id: " + id);
		try {
			PaymentData instance = entityManager.find(PaymentData.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	

	public PaymentData loadPaymentDataByIdUser(Integer idUser) {
        List<PaymentData> paymentList = entityManager.createQuery("from PaymentData p where p.idUser = :idUser")
            .setParameter("idUser", idUser).getResultList();
        if(paymentList.size()==1) return paymentList.get(0);
        else return new PaymentData();
    }
}
