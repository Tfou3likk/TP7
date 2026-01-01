package fr.univ.tours.jakartaee.tp7.business.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.univ.tours.jakartaee.tp7.business.AddDiskService;
import fr.univ.tours.jakartaee.tp7.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp7.dao.AddDiskDAO;

public class AddDiskServiceImpl implements AddDiskService {
	
	private final Set<String> diskByReference = new HashSet<>();
	private AddDiskDAO addDiskDao;
	
	
	public AddDiskServiceImpl(AddDiskDAO addDiskDao) {
		super();
		this.addDiskDao = addDiskDao;
	}

	@Override
	public List<Disk> listAllDisk() {
		// TODO Auto-generated method stub
		return addDiskDao.listAllDisk();
	}

	@Override
	public Disk getDiskById(String DiskId) {
		// TODO Auto-generated method stub
		return addDiskDao.getDiskById(DiskId);
	}

	@Override
	public void addDisk(Disk disk) {
		// TODO Auto-generated method stub
		addDiskDao.addDisk(disk);
	}
	
	

}
