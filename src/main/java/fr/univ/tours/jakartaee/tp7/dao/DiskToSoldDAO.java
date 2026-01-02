package fr.univ.tours.jakartaee.tp7.dao;



import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import fr.univ.tours.jakartaee.tp7.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp7.entities.DiskToSoldEntity;


public interface DiskToSoldDAO {

    List<DiskToSoldEntity> listAll();

    List<DiskToSoldEntity> listAllByIds(Collection<String> diskIds);

    void removeFromMarketplace(Collection<String> diskIds);
}
