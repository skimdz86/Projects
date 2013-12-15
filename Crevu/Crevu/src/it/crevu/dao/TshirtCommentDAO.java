package it.crevu.dao;

import it.crevu.db.TshirtComment;

public interface TshirtCommentDAO {

	public void persist(TshirtComment transientInstance);
    public void remove(TshirtComment persistentInstance);
    public TshirtComment merge(TshirtComment detachedInstance);
    public TshirtComment findById(Integer id);
}
