package fr.univ.tours.jakartaee.tp6.dao;



import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import fr.univ.tours.jakartaee.tp6.business.pojo.DiskToSold;


public interface DiskToSoldDAO {

    List<DiskToSold> listAll() throws SQLException;

    List<DiskToSold> listAllByIds(Collection<String> diskIds) throws SQLException;

    void removeFromMarketplace(Collection<String> diskIds) throws SQLException;
}
