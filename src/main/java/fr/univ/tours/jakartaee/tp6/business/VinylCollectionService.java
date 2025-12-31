package fr.univ.tours.jakartaee.tp6.business;

import java.util.List;

import fr.univ.tours.jakartaee.tp6.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp6.business.pojo.User;



public interface VinylCollectionService {
	
	List<Disk> listCollection(User owner);

}
