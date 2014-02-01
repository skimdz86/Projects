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
 * Home object for domain model class Notification.
 * @see it.crevu.db.Notification
 * @author Hibernate Tools
 */
//@Stateless
@Component("NotificationDAO")
@Transactional
//@Repository
public class NotificationHome {

	private static final Log log = LogFactory.getLog(NotificationHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Notification transientInstance) {
		log.debug("persisting Notification instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Notification persistentInstance) {
		log.debug("removing Notification instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Notification merge(Notification detachedInstance) {
		log.debug("merging Notification instance");
		try {
			Notification result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Notification findById(NotificationId id) {
		log.debug("getting Notification instance with id: " + id);
		try {
			Notification instance = entityManager.find(Notification.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	

	public List<Notification> loadNotificationByIdUser(Integer idUser) {
        return entityManager.createQuery("from Notification n where n.idUser = :idUser")
            .setParameter("idUser", idUser).getResultList();
    }
}
