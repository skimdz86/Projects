package it.crevu.dao;

import it.crevu.db.SocialAccount;
import it.crevu.db.User;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SocialAccountDAO {

        public void persist(SocialAccount transientInstance);
        public void remove(SocialAccount persistentInstance);
        public SocialAccount merge(SocialAccount detachedInstance);
        public SocialAccount findById(Integer id);
        
        public SocialAccount findByUserAndType(Integer userId, String accountType);
        public List<SocialAccount> loadSocialAccountByIdUser(Integer idUser);
        
        public void saveAccessToken(Integer userId, String accountType, String tokenValue, String tokenSecret);
        
        public SocialAccount getUserBySocialId(String socialId, String accountType);
}
