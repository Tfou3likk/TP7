package fr.univ.tours.jakartaee.tp6.business.impl;

import fr.univ.tours.jakartaee.tp6.business.DiskToSoldService;
import fr.univ.tours.jakartaee.tp6.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp6.dao.DiskToSoldDAO;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DiskToSoldServiceImpl implements DiskToSoldService {
	
	
	private DiskToSoldDAO diskToSoldDAO;
	
	public DiskToSoldServiceImpl(DiskToSoldDAO diskToSoldDAO) {
		super();
		this.diskToSoldDAO = diskToSoldDAO;
	}

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
