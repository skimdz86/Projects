package it.crevu.dao;

import it.crevu.db.UserTshirtRanking;
import it.crevu.db.UserTshirtRankingId;

public interface UserTshirtRankingDAO {

	public void persist(UserTshirtRanking transientInstance);
    public void remove(UserTshirtRanking persistentInstance);
    public UserTshirtRanking merge(UserTshirtRanking detachedInstance);
    public UserTshirtRanking findById(UserTshirtRankingId id);
}
