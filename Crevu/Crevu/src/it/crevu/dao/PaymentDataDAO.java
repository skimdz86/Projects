package it.crevu.dao;

import it.crevu.db.PaymentData;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PaymentDataDAO {

        public void persist(PaymentData transientInstance);
        public void remove(PaymentData persistentInstance);
        public PaymentData merge(PaymentData detachedInstance);
        public PaymentData findById(Integer id);
        public PaymentData loadPaymentDataByIdUser(Integer idUser);
}