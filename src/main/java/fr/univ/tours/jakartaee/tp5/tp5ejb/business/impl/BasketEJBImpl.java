package fr.univ.tours.jakartaee.tp5.tp5ejb.business.impl;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.BasketEJB;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.TransactionEJB;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.User;
import fr.univ.tours.jakartaee.tp5.tp5ejb.dao.DiskToSoldDAO;
import jakarta.ejb.EJB;
import jakarta.ejb.Remove;
import jakarta.ejb.Stateful;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Stateful(name="BasketEJB")
public class BasketEJBImpl implements BasketEJB {

    private final Set<String> basketByReference = new HashSet<>();
    @EJB
    private DiskToSoldDAO  diskToSoldDAO;
    
    @EJB
    private TransactionEJB transactionEJB;
    
    
    @Override
    public void addToBasket(String diskReference) {
        // TODO to implements
    	basketByReference.add(diskReference);
    }


    @Override
    public List<DiskToSold> getBasketDetail() throws SQLException {
        // TODO to implements
    	return diskToSoldDAO.listAllByIds(basketByReference);
    }

    @Override
    public void removeFromBasket(String diskReference) {
        // TODO to implements
    	basketByReference.remove(diskReference);
    }

    @Override
    public boolean makeOrder(User buyer) throws SQLException{
        // TODO to implements
    	if(basketByReference.isEmpty()) {
    		return false;
    	}
    	transactionEJB.makeTransaction(buyer, basketByReference);
    	return true;
    }

    @Remove
    public void clearBasket(){
    	basketByReference.clear();
    }
}
