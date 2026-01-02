package fr.univ.tours.jakartaee.tp7.business;

import java.util.List;

import fr.univ.tours.jakartaee.tp7.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp7.entities.DiskEntity;

public interface AddDiskService {
	
	List<DiskEntity> listAllDisk();
	
	DiskEntity getDiskById(String DiskId);
	
	void addDisk(DiskEntity disk);

}
