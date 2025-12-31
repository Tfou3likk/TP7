package fr.univ.tours.jakartaee.tp6.business;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import fr.univ.tours.jakartaee.tp6.business.pojo.DiskToSold;

public interface DiskToSoldService {
    List<DiskToSold> listAll();

    List<DiskToSold> listAllByIds(Collection<String> diskIdentificationCodes);
}
