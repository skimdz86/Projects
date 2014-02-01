package it.crevu.dao;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.TshirtCategory;

import java.util.List;

@Transactional
public interface TshirtCategoryDAO {

        public void persist(TshirtCategory transientInstance);
        public void remove(TshirtCategory persistentInstance);
        public TshirtCategory merge(TshirtCategory detachedInstance);
        public TshirtCategory findById(Integer id);
	public List<TshirtCategory> loadTshirtCategoryByIdCategory(Integer idCategory);
}