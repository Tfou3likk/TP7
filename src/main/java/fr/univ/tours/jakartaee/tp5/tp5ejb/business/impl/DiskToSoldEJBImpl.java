package fr.univ.tours.jakartaee.tp5.tp5ejb.business.impl;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.DiskToSoldEJB;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp5.tp5ejb.dao.DiskToSoldDAO;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Stateless
public class DiskToSoldEJBImpl implements DiskToSoldEJB {
	
	@EJB
	DiskToSoldDAO diskToSoldDAO;
	
    @Override
    public List<DiskToSold> listAll() throws SQLException {
        // TODO to implements
        
    	return diskToSoldDAO.listAll();
    }

    @Override
    public List<DiskToSold> listAllByIds(Collection<String> diskIdentificationCodes) throws SQLException {
        // TODO to implements
        return diskToSoldDAO.listAllByIds(diskIdentificationCodes);
    }
}
