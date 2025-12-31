package fr.univ.tours.jakartaee.tp6.business.impl;

import fr.univ.tours.jakartaee.tp6.business.BasketService;
import fr.univ.tours.jakartaee.tp6.business.TransactionService;
import fr.univ.tours.jakartaee.tp6.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp6.business.pojo.User;
import fr.univ.tours.jakartaee.tp6.dao.DiskToSoldDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class BasketServiceImpl implements BasketService {

    private final Set<String> basketByReference = new HashSet<>();
    
    private DiskToSoldDAO  diskToSoldDAO;
    
    private TransactionService transactionService;
    
    
    
    
    public BasketServiceImpl(DiskToSoldDAO diskToSoldDAO, TransactionService transactionService) {
		super();
		this.diskToSoldDAO = diskToSoldDAO;
		this.transactionService = transactionService;
	}


	@Override
    public void addToBasket(String diskReference) {
        // TODO to implements
    	basketByReference.add(diskReference);
    }


    @Override
    public List<DiskToSold> getBasketDetail(){
        // TODO to implements
    	return diskToSoldDAO.listAllByIds(basketByReference);
    }

    @Override
    public void removeFromBasket(String diskReference) {
        // TODO to implements
    	basketByReference.remove(diskReference);
    }

    @Override
    public boolean makeOrder(User buyer){
        // TODO to implements
    	if(basketByReference.isEmpty()) {
    		return false;
    	}
    	transactionService.makeTransaction(buyer, basketByReference);
    	return true;
    }

    
    public void clearBasket(){
    	basketByReference.clear();
    }
}
