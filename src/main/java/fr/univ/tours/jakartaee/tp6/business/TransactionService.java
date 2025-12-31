package fr.univ.tours.jakartaee.tp6.business;



import java.sql.SQLException;
import java.util.Collection;

import fr.univ.tours.jakartaee.tp6.business.pojo.User;


public interface TransactionService {

    void makeTransaction(User buyer, Collection<String> diskIds);

}
