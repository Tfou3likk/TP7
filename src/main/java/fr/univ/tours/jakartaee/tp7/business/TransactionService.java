package fr.univ.tours.jakartaee.tp7.business;



import java.sql.SQLException;
import java.util.Collection;

import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import fr.univ.tours.jakartaee.tp7.entities.UserEntity;


public interface TransactionService {

    void makeTransaction(UserEntity buyer, Collection<String> diskIds);

}
