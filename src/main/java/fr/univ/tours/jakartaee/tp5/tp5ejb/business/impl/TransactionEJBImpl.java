package fr.univ.tours.jakartaee.tp5.tp5ejb.business.impl;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.TransactionEJB;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.User;
import fr.univ.tours.jakartaee.tp5.tp5ejb.dao.DiskToSoldDAO;
import fr.univ.tours.jakartaee.tp5.tp5ejb.dao.VinylCollectionDAO;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.sql.SQLException;
import java.util.Collection;

@Stateless
public class TransactionEJBImpl implements TransactionEJB {
	
	@EJB
    private DiskToSoldDAO diskToSoldDAO;
    
    @EJB
    private VinylCollectionDAO vinylCollectionDAO;

    @Override
    public void makeTransaction(User buyer, Collection<String> diskIds) throws SQLException{
        diskToSoldDAO.removeFromMarketplace(diskIds);
        vinylCollectionDAO.addToCollection(buyer,diskIds);
    }
}
