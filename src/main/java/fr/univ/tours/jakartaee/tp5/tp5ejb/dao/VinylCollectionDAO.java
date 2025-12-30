package fr.univ.tours.jakartaee.tp5.tp5ejb.dao;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.User;
import jakarta.ejb.Local;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Local
public interface VinylCollectionDAO {

    void addToCollection(User buyer, Collection<String> diskIds) throws SQLException;
    
    List<Disk> listCollection(User owner);

}
