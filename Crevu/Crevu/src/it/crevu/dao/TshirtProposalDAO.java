package it.crevu.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.crevu.db.TshirtProposal;

@Transactional
public interface TshirtProposalDAO {

        public void persist(TshirtProposal transientInstance);
        public void remove(TshirtProposal persistentInstance);
        public TshirtProposal merge(TshirtProposal detachedInstance);
        public TshirtProposal findById(Integer id);
        public List<TshirtProposal> loadTshirtProposalByIdUser(Integer idUser);
	public List<TshirtProposal> loadTshirtProposalByIdText(Integer idText);
}