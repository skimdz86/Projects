package it.crevu.dao;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.Revenue;

import java.util.List;

@Transactional
public interface RevenueDAO {

        public void persist(Revenue transientInstance);
        public void remove(Revenue persistentInstance);
        public Revenue merge(Revenue detachedInstance);
        public Revenue findById(Integer id);
        public List<Revenue> loadRevenueByIdSoldTshirt(Integer idSoldTshirt);
        public List<Revenue> loadRevenueByIdUser(Integer idUser);
}