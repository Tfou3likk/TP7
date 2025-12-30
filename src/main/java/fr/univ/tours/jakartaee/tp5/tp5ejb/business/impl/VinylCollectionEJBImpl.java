package fr.univ.tours.jakartaee.tp5.tp5ejb.business.impl;

import java.util.List;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.User;
import fr.univ.tours.jakartaee.tp5.tp5ejb.dao.VinylCollectionDAO;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class VinylCollectionEJBImpl implements fr.univ.tours.jakartaee.tp5.tp5ejb.business.VinylCollectionEJB {
	
	@EJB
	VinylCollectionDAO vinylCollectionDAO;
	@Override
	public List<Disk> listCollection(User owner) {
		// TODO Auto-generated method stub
		return vinylCollectionDAO.listCollection(owner);
	}

}
