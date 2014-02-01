package it.crevu.dao;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.Transaction;

import java.util.List;

@Transactional
public interface TransactionDAO {

        public void persist(Transaction transientInstance);
        public void remove(Transaction persistentInstance);
        public Transaction merge(Transaction detachedInstance);
        public Transaction findById(Integer id);
        public List<Transaction> loadTransactionByIdWarehouse(Integer idWarehouse);
	public List<Transaction> loadTransactionByIdSupplierOrder(Integer idSupplierOrder);
}