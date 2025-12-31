package fr.univ.tours.jakartaee.tp6.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.univ.tours.jakartaee.tp6.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp6.business.pojo.User;
import fr.univ.tours.jakartaee.tp6.dao.VinylCollectionDAO;


@Service
public class VinylCollectionServiceImpl implements fr.univ.tours.jakartaee.tp6.business.VinylCollectionService {
	
	
	private VinylCollectionDAO vinylCollectionDAO;
	@Override
	public List<Disk> listCollection(User owner) {
		// TODO Auto-generated method stub
		return vinylCollectionDAO.listCollection(owner);
	}

}
