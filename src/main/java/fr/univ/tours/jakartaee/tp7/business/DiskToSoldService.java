package fr.univ.tours.jakartaee.tp7.business;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import fr.univ.tours.jakartaee.tp7.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp7.entities.DiskToSoldEntity;

public interface DiskToSoldService {
    List<DiskToSoldEntity> listAll();

    List<DiskToSoldEntity> listAllByIds(Collection<String> diskIdentificationCodes);
}
