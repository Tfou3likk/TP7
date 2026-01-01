package fr.univ.tours.jakartaee.tp7.dao;



import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import fr.univ.tours.jakartaee.tp7.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp7.business.pojo.User;


public interface VinylCollectionDAO {

    void addToCollection(User buyer, Collection<String> diskIds);
    
    void addToCollectionbyId(User owner, String diskId);
    
    List<Disk> listCollection(User owner);

}
