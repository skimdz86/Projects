package it.crevu.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.TextWish;

@Transactional
public interface TextWishDAO {

        public void persist(TextWish transientInstance);
        public void remove(TextWish persistentInstance);
        public TextWish merge(TextWish detachedInstance);
        public TextWish findById(Integer id);
        public List<TextWish> loadTextWishByIdUser(Integer idUser);
	public List<TextWish> loadTextWishByIdText(Integer idText);
}