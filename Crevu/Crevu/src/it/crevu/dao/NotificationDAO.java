package it.crevu.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.Notification;

@Transactional
public interface NotificationDAO {

        public void persist(Notification transientInstance);
        public void remove(Notification persistentInstance);
        public Notification merge(Notification detachedInstance);
        public Notification findById(Integer id);
        public List<Notification> loadNotificationByIdUser(Integer idUser);
}