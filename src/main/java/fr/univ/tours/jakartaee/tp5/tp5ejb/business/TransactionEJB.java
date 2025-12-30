package fr.univ.tours.jakartaee.tp5.tp5ejb.business;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.User;
import jakarta.ejb.Local;

import java.sql.SQLException;
import java.util.Collection;

@Local
public interface TransactionEJB {

    void makeTransaction(User buyer, Collection<String> diskIds) throws SQLException;

}
