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
 * Home object for domain model class TshirtProposal.
 * @see it.crevu.db.TshirtProposal
 * @author Hibernate Tools
 */
//@Stateless
@Component("TshirtProposalDAO")
@Transactional
//@Repository
public class TshirtProposalHome {

	private static final Log log = LogFactory.getLog(TshirtProposalHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TshirtProposal transientInstance) {
		log.debug("persisting TshirtProposal instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TshirtProposal persistentInstance) {
		log.debug("removing TshirtProposal instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TshirtProposal merge(TshirtProposal detachedInstance) {
		log.debug("merging TshirtProposal instance");
		try {
			TshirtProposal result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TshirtProposal findById(TshirtProposalId id) {
		log.debug("getting TshirtProposal instance with id: " + id);
		try {
			TshirtProposal instance = entityManager.find(TshirtProposal.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
    ;
public List<TshirtProposalData> loadTshirtProposalByIdText(Integer idText){
	return entityManager.createQuery("from TshirtProposal tp, User u, Text t where u.idText = :idText and u.idUser=tp.idUser and u.id=tp.idUser")
            .setParameter("idText", idText).getResultList();
}
	
public List<TshirtProposalData> loadTshirtProposalByIdUser(Integer idUser) {
    return entityManager.createQuery("from TshirtProposal tp, User u, Text t where u.idUser = :idUser and u.idUser=tp.idUser and t.id=tp.idText")
            .setParameter("idUser", idUser).getResultList();
    }
}
