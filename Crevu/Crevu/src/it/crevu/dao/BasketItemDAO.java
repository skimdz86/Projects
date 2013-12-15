package it.crevu.dao;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.BasketItem;

import java.util.List;

@Transactional
public interface BasketItemDAO {

        public void persist(BasketItem transientInstance);
        public void remove(BasketItem persistentInstance);
        public BasketItem merge(BasketItem detachedInstance);
        public BasketItem findById(Integer id);
	public List<BasketItem> loadBasketItemByIdUser(Integer idUser);
}