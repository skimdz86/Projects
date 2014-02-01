package it.crevu.db;

// Generated 26-mar-2013 21.12.17 by Hibernate Tools 3.6.0

import it.crevu.dao.SocialAccountDAO;
import it.crevu.log.Logger;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class SocialAccount.
 * @see it.crevu.db.SocialAccount
 * @author Hibernate Tools
 */
//@Stateless
@Component("SocialAccountDAO")
@Transactional
//@Repository
public class SocialAccountHome implements SocialAccountDAO {

	private static final Logger log = Logger.getInstance(SocialAccountHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(SocialAccount transientInstance) {
		log.debug("persisting SocialAccount instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(SocialAccount persistentInstance) {
		log.debug("removing SocialAccount instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public SocialAccount merge(SocialAccount detachedInstance) {
		log.debug("merging SocialAccount instance");
		try {
			SocialAccount result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SocialAccount findById(Integer id) {
		log.debug("getting SocialAccount instance with id: " + id);
		try {
			SocialAccount instance = entityManager
					.find(SocialAccount.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public SocialAccount findByUserAndType(Integer userId, String accountType) {
		log.debug("getting SocialAccount "+accountType+" instance with user id: " + userId);
		try {
			List<SocialAccount> instance = entityManager.createQuery("from SocialAccount s where s.idUser = :idUser and s.accountType = :accountType")
		            .setParameter("idUser", userId).setParameter("accountType", accountType).getResultList();
			SocialAccount res = new SocialAccount();
			if(instance.size()>0) res = instance.get(0);
			log.debug("get successful");
			return res;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<SocialAccount> loadSocialAccountByIdUser(Integer idUser) {
        return entityManager.createQuery("from SocialAccount s where s.idUser = :idUser")
            .setParameter("idUser", idUser).getResultList();
    }

	@Override
	public void saveAccessToken(Integer userId, String accountType,
			String tokenValue, String tokenSecret) {
		
		SocialAccount account = findByUserAndType(userId, accountType);
		if(account!=null){
			account.setAccessTokenValue(tokenValue);
			account.setAccessTokenSecret(tokenSecret);
			entityManager.merge(account);
		}
	}

	@Override
	public SocialAccount getUserBySocialId(String socialId, String accountType) {
		List<SocialAccount> accounts = entityManager.createQuery("from SocialAccount s where s.socialId = :socialId and s.accountType = :accountType")
        .setParameter("socialId", socialId).setParameter("accountType", accountType).getResultList();
		
		if(accounts.size()==1) return accounts.get(0);
		else return null;
	}
}
