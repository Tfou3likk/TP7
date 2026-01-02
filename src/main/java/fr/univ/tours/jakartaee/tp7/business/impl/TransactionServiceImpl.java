package fr.univ.tours.jakartaee.tp7.business.impl;

import fr.univ.tours.jakartaee.tp7.business.TransactionService;
import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import fr.univ.tours.jakartaee.tp7.dao.DiskToSoldDAO;
import fr.univ.tours.jakartaee.tp7.dao.VinylCollectionDAO;
import fr.univ.tours.jakartaee.tp7.entities.UserEntity;

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
    public void makeTransaction(UserEntity buyer, Collection<String> diskIds){
        diskToSoldDAO.removeFromMarketplace(diskIds);
        vinylCollectionDAO.addToCollection(buyer,diskIds);
    }
}
