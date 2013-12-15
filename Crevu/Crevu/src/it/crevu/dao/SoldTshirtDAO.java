package it.crevu.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.SoldTshirt;

@Transactional
public interface SoldTshirtDAO {

        public void persist(SoldTshirt transientInstance);
        public void remove(SoldTshirt persistentInstance);
        public SoldTshirt merge(SoldTshirt detachedInstance);
        public SoldTshirt findById(Integer id);
        public List<SoldTshirt> loadSoldTshirtByIdSeller(Integer idSeller);
        public List<SoldTshirt> loadSoldTshirtByIdBuyer(Integer idBuyer);
}