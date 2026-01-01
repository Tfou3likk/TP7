package fr.univ.tours.jakartaee.tp6.business.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.univ.tours.jakartaee.tp6.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp6.business.pojo.User;
import fr.univ.tours.jakartaee.tp6.dao.VinylCollectionDAO;


@Service
public class VinylCollectionServiceImpl implements fr.univ.tours.jakartaee.tp6.business.VinylCollectionService {
	
	
	
	private VinylCollectionDAO vinylCollectionDAO;
	
	
	
	public VinylCollectionServiceImpl(VinylCollectionDAO vinylCollectionDAO) {
		super();
		this.vinylCollectionDAO = vinylCollectionDAO;
	}



	@Override
	public List<Disk> listCollection(User owner) {
		// TODO Auto-generated method stub
		return vinylCollectionDAO.listCollection(owner);
	}



	@Override
	public void addToCollection(User buyer, Collection<String> diskIds) {
		// TODO Auto-generated method stub
		vinylCollectionDAO.addToCollection(buyer, diskIds);
	}



	@Override
	public void addToCollectionbyId(User owner, String diskId) {
		// TODO Auto-generated method stub
		vinylCollectionDAO.addToCollectionbyId(owner, diskId);
	}
	
	

}
