package it.crevu.dao;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.Payment;

import java.util.List;

@Transactional
public interface PaymentDAO {

        public void persist(Payment transientInstance);
        public void remove(Payment persistentInstance);
        public Payment merge(Payment detachedInstance);
        public Payment findById(Integer id);
	public List<Payment> loadPaymentByIdOrderDeal(Integer idOrderDeal);
}