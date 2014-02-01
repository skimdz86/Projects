package it.crevu.dao;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.WishlistItem;

import java.util.List;

@Transactional
public interface WishlistItemDAO {

        public void persist(WishlistItem transientInstance);
        public void remove(WishlistItem persistentInstance);
        public WishlistItem merge(WishlistItem detachedInstance);
        public WishlistItem findById(Integer id);
	public List<WishlistItem> loadWishlistItemByIdUser(Integer idUser);
	public List<WishlistItem> loadWishlistItemByIdTshirtProposal(Integer idTshirtProposal);
}