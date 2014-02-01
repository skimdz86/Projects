package it.crevu.db;

// Generated 26-mar-2013 21.12.17 by Hibernate Tools 3.6.0

import java.util.Collection;
import java.util.List;
import it.crevu.databean.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class TextWish.
 * @see it.crevu.db.TextWish
 * @author Hibernate Tools
 */
//@Stateless
@Component("TextWishDAO")
@Transactional
//@Repository
public class TextWishHome {

	private static final Log log = LogFactory.getLog(TextWishHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TextWish transientInstance) {
		log.debug("persisting TextWish instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TextWish persistentInstance) {
		log.debug("removing TextWish instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TextWish merge(TextWish detachedInstance) {
		log.debug("merging TextWish instance");
		try {
			TextWish result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TextWish findById(Integer id) {
		log.debug("getting TextWish instance with id: " + id);
		try {
			TextWish instance = entityManager.find(TextWish.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	
	public List<TextWishData> loadTextWishByIdText(Integer idText){
        return entityManager.createQuery("from TextWish tw, User u, Text t where u.idText = :idText and u.idUser=tw.idUser and t.id=tw.idText")
             .setParameter("idText", idText).getResultList();
     }
	


	public List<TextWishData> loadTextWishByIdUser(Integer idUser) {
        return entityManager.createQuery("from TextWish tw, User u, Text t where u.idUser = :idUser and u.idUser=tw.idUser and t.id=tw.idText")
            .setParameter("idUser", idUser).getResultList();
    }
}
