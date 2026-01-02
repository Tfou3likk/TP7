package fr.univ.tours.jakartaee.tp7.dao;


import java.util.List;

import fr.univ.tours.jakartaee.tp7.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp7.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp7.entities.DiskEntity;

public interface AddDiskDAO {
	
	List<DiskEntity> listAllDisk();
	
	DiskEntity getDiskById(String DiskId);
	
	void addDisk(DiskEntity disk);

}
