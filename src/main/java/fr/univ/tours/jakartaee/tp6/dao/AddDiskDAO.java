package fr.univ.tours.jakartaee.tp6.dao;


import java.util.List;

import fr.univ.tours.jakartaee.tp6.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp6.business.pojo.DiskToSold;

public interface AddDiskDAO {
	
	List<Disk> listAllDisk();
	
	Disk getDiskById(String DiskId);
	
	void addDisk(Disk disk);

}
