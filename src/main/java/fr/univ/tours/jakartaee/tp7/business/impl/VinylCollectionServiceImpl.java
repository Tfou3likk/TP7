package fr.univ.tours.jakartaee.tp7.business.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.univ.tours.jakartaee.tp7.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import fr.univ.tours.jakartaee.tp7.dao.VinylCollectionDAO;
import fr.univ.tours.jakartaee.tp7.entities.DiskEntity;
import fr.univ.tours.jakartaee.tp7.entities.UserEntity;


@Service
public class VinylCollectionServiceImpl implements fr.univ.tours.jakartaee.tp7.business.VinylCollectionService {
	
	
	
	private VinylCollectionDAO vinylCollectionDAO;
	
	
	
	public VinylCollectionServiceImpl(VinylCollectionDAO vinylCollectionDAO) {
		super();
		this.vinylCollectionDAO = vinylCollectionDAO;
	}



	@Override
	public List<DiskEntity> listCollection(UserEntity owner) {
		// TODO Auto-generated method stub
		return vinylCollectionDAO.listCollection(owner);
	}



	@Override
	public void addToCollection(UserEntity buyer, Collection<String> diskIds) {
		// TODO Auto-generated method stub
		vinylCollectionDAO.addToCollection(buyer, diskIds);
	}



	@Override
	public void addToCollectionbyId(UserEntity owner, String diskId) {
		// TODO Auto-generated method stub
		vinylCollectionDAO.addToCollectionbyId(owner, diskId);
	}
	
	

}
