package fr.univ.tours.jakartaee.tp7.dao;



import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import fr.univ.tours.jakartaee.tp7.business.pojo.DiskToSold;


public interface DiskToSoldDAO {

    List<DiskToSold> listAll();

    List<DiskToSold> listAllByIds(Collection<String> diskIds);

    void removeFromMarketplace(Collection<String> diskIds);
}
