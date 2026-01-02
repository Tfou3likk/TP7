package fr.univ.tours.jakartaee.tp7.dao;



import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import fr.univ.tours.jakartaee.tp7.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import fr.univ.tours.jakartaee.tp7.entities.DiskEntity;
import fr.univ.tours.jakartaee.tp7.entities.UserEntity;


public interface VinylCollectionDAO {

    void addToCollection(UserEntity buyer, Collection<String> diskIds);
    
    void addToCollectionbyId(UserEntity owner, String diskId);
    
    List<DiskEntity> listCollection(UserEntity owner);

}
