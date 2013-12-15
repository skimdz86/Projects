package it.crevu.dao;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.OrderedTshirt;

import java.util.List;

@Transactional
public interface OrderedTshirtDAO {

        public void persist(OrderedTshirt transientInstance);
        public void remove(OrderedTshirt persistentInstance);
        public OrderedTshirt merge(OrderedTshirt detachedInstance);
        public OrderedTshirt findById(Integer id);
	public List<OrderedTshirt> loadOrderedTshirtByIdOrderDeal(Integer idOrderDeal);
	public List<OrderedTshirt> loadOrderedTshirtByIdSoldTshirt(Integer idSoldTshirt);
}