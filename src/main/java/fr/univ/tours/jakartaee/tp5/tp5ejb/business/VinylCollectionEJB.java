package fr.univ.tours.jakartaee.tp5.tp5ejb.business;

import java.util.List;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.User;
import jakarta.ejb.Local;

@Local
public interface VinylCollectionEJB {
	
	List<Disk> listCollection(User owner);

}
