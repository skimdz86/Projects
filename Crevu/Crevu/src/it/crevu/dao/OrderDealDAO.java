package it.crevu.dao;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.OrderDeal;

import java.util.List;

@Transactional
public interface OrderDealDAO {

        public void persist(OrderDeal transientInstance);
        public void remove(OrderDeal persistentInstance);
        public OrderDeal merge(OrderDeal detachedInstance);
        public OrderDeal findById(Integer id);	
	public List<OrderDeal> loadOrderDealByIdSupplierOrder(Integer idSupplierOrder);
}