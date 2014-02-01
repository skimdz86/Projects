package it.crevu.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.Text;

@Transactional
public interface TextDAO {

        public void persist(Text transientInstance);
        public void remove(Text persistentInstance);
        public Text merge(Text detachedInstance);
        public Text findById(Integer id);
        public List<Text> loadText();//per averlo in ordine descrescente in base ai voti
}