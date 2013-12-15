package it.crevu.dao;

import it.crevu.db.UserCommunication;

public interface UserCommunicationDAO {

	public void persist(UserCommunication transientInstance);
    public void remove(UserCommunication persistentInstance);
    public UserCommunication merge(UserCommunication detachedInstance);
    public UserCommunication findById(Integer id);
}
