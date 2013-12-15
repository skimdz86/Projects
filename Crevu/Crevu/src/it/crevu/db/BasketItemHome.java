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
 * Home object for domain model class BasketItem.
 * @see it.crevu.db.BasketItem
 * @author Hibernate Tools
 */
//@Stateless
@Component("BasketItemDAO")
@Transactional
//@Repository
public class BasketItemHome {

	private static final Log log = LogFactory.getLog(BasketItemHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(BasketItem transientInstance) {
		log.debug("persisting BasketItem instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(BasketItem persistentInstance) {
		log.debug("removing BasketItem instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public BasketItem merge(BasketItem detachedInstance) {
		log.debug("merging BasketItem instance");
		try {
			BasketItem result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BasketItem findById(Integer id) {
		log.debug("getting BasketItem instance with id: " + id);
		try {
			BasketItem instance = entityManager.find(BasketItem.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<BasketItem> loadBasketItemByIdUser(Integer idUser) {
        return entityManager.createQuery("from BasketItem b where b.idUser = :idUser")
            .setParameter("idUser", idUser).getResultList();
    }
}
