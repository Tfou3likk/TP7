package fr.univ.tours.jakartaee.tp5.tp5ejb.business;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.DiskToSold;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface DiskToSoldEJB {
    List<DiskToSold> listAll() throws SQLException;

    List<DiskToSold> listAllByIds(Collection<String> diskIdentificationCodes) throws SQLException;
}
