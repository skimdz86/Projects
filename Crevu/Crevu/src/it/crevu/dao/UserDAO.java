package it.crevu.dao;

import it.crevu.db.User;
import it.crevu.exception.UserNotFoundException;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDAO {

        public void persist(User transientInstance);
        public void remove(User persistentInstance);
        public User merge(User detachedInstance);
        public User findById(Integer id);
        public User loadUserByUsername(String username) throws UserNotFoundException;
        public List<User> loadUserByEmail(String email);
        public List<User> loadUserByNationality(String nationality);
        
        public Boolean login(String username, String password);
		public Boolean autoLogin(String user, String cookieSecret);
}