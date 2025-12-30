package fr.univ.tours.jakartaee.tp5.tp5ejb.dao;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.DiskToSold;
import jakarta.ejb.Local;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Local
public interface DiskToSoldDAO {

    List<DiskToSold> listAll() throws SQLException;

    List<DiskToSold> listAllByIds(Collection<String> diskIds) throws SQLException;

    void removeFromMarketplace(Collection<String> diskIds) throws SQLException;
}
