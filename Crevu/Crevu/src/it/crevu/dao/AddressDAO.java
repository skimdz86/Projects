package it.crevu.dao;

import it.crevu.db.Address;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AddressDAO {

        public void persist(Address transientInstance);
        public void remove(Address persistentInstance);
        public Address merge(Address detachedInstance);
        public Address findById(Integer id);
        public List<Address> loadAddressByIdUser(Integer idUser);
}