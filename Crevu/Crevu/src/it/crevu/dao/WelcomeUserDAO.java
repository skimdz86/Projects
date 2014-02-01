package it.crevu.dao;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.WelcomeUser;


@Transactional
public interface WelcomeUserDAO {

        public void persist(WelcomeUser transientInstance);
        public void remove(WelcomeUser persistentInstance);
        public WelcomeUser merge(WelcomeUser detachedInstance);
        public WelcomeUser findById(Integer id);
        public List<WelcomeUser> loadWelcomeUserByNickname(String nickname);
        public List<WelcomeUser> loadWelcomeUserByEmail(String email);
}