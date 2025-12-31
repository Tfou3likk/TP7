package fr.univ.tours.jakartaee.tp6.business.impl;

import fr.univ.tours.jakartaee.tp6.business.TransactionService;
import fr.univ.tours.jakartaee.tp6.business.pojo.User;
import fr.univ.tours.jakartaee.tp6.dao.DiskToSoldDAO;
import fr.univ.tours.jakartaee.tp6.dao.VinylCollectionDAO;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	
    private DiskToSoldDAO diskToSoldDAO;
    
    private VinylCollectionDAO vinylCollectionDAO;
    
    
    public TransactionServiceImpl(DiskToSoldDAO diskToSoldDAO, VinylCollectionDAO vinylCollectionDAO) {
		super();
		this.diskToSoldDAO = diskToSoldDAO;
		this.vinylCollectionDAO = vinylCollectionDAO;
	}



	@Override
    public void makeTransaction(User buyer, Collection<String> diskIds) throws SQLException{
        diskToSoldDAO.removeFromMarketplace(diskIds);
        vinylCollectionDAO.addToCollection(buyer,diskIds);
    }
}
