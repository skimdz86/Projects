package it.crevu.dao;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.SupplierOrder;

import java.util.List;

@Transactional
public interface SupplierOrderDAO {

        public void persist(SupplierOrder transientInstance);
        public void remove(SupplierOrder persistentInstance);
        public SupplierOrder merge(SupplierOrder detachedInstance);
        public SupplierOrder findById(Integer id);
	public List<SupplierOrder> loadSupplierOrderByIdOrderDeal(Integer idOrderDeal);
	public List<SupplierOrder> loadSupplierOrderByIdWarehouse(Integer idWarehouse);
}