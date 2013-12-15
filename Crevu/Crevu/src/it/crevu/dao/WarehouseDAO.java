package it.crevu.dao;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.Warehouse;

@Transactional
public interface WarehouseDAO {

        public void persist(Warehouse transientInstance);
        public void remove(Warehouse persistentInstance);
        public Warehouse merge(Warehouse detachedInstance);
        public Warehouse  findById(Integer id);
}