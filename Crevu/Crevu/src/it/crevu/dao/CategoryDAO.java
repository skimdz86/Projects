package it.crevu.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.Category;

@Transactional
public interface CategoryDAO {

        public void persist(Category transientInstance);
        public void remove(Category persistentInstance);
        public Category merge(Category detachedInstance);
        public Category findById(Integer id);
        public List<Category> loadCategory();//in ordine alfabetico
}