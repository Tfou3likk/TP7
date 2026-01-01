package fr.univ.tours.jakartaee.tp6.business;

import java.util.List;

import fr.univ.tours.jakartaee.tp6.business.pojo.Disk;

public interface AddDiskService {
	
	List<Disk> listAllDisk();
	
	Disk getDiskById(String DiskId);
	
	void addDisk(Disk disk);

}
