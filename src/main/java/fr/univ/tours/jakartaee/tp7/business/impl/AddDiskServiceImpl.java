package fr.univ.tours.jakartaee.tp7.business.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.univ.tours.jakartaee.tp7.business.AddDiskService;
import fr.univ.tours.jakartaee.tp7.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp7.dao.AddDiskDAO;
import fr.univ.tours.jakartaee.tp7.entities.DiskEntity;

public class AddDiskServiceImpl implements AddDiskService {
	
	private final Set<String> diskByReference = new HashSet<>();
	private AddDiskDAO addDiskDao;
	
	
	public AddDiskServiceImpl(AddDiskDAO addDiskDao) {
		super();
		this.addDiskDao = addDiskDao;
	}

	@Override
	public List<DiskEntity> listAllDisk() {
		// TODO Auto-generated method stub
		return addDiskDao.listAllDisk();
	}

	@Override
	public DiskEntity getDiskById(String DiskId) {
		// TODO Auto-generated method stub
		return addDiskDao.getDiskById(DiskId);
	}

	@Override
	public void addDisk(DiskEntity disk) {
		// TODO Auto-generated method stub
		addDiskDao.addDisk(disk);
	}
	
	

}
