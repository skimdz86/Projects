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
 * Home object for domain model class WishlistItem.
 * @see it.crevu.db.WishlistItem
 * @author Hibernate Tools
 */
//@Stateless
@Component("WishlistItemDAO")
@Transactional
//@Repository
public class WishlistItemHome {

	private static final Log log = LogFactory.getLog(WishlistItemHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(WishlistItem transientInstance) {
		log.debug("persisting WishlistItem instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(WishlistItem persistentInstance) {
		log.debug("removing WishlistItem instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public WishlistItem merge(WishlistItem detachedInstance) {
		log.debug("merging WishlistItem instance");
		try {
			WishlistItem result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WishlistItem findById(Integer id) {
		log.debug("getting WishlistItem instance with id: " + id);
		try {
			WishlistItem instance = entityManager.find(WishlistItem.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<WishlistItem> loadWishlistItemByIdUser(Integer idUser)
	{
	       return entityManager.createQuery("from WishListItem w where w.idUser = :idUser")
		           .setParameter("idUser", idUser).getResultList();
	}
	
	public List<WishlistItem> loadWishlistItemByIdTshirtProposal(Integer idTshirtProposal)
	{
	       return entityManager.createQuery("from WishListItem w where w.idTshirtProposal = :idTshirtProposal")
		           .setParameter("idTshirtProposal", idTshirtProposal).getResultList();
	}
}
