package fr.univ.tours.jakartaee.tp5.tp5ejb.dao;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.User;
import jakarta.ejb.Local;

@Local
public interface UserDao {

    // TODO to implement
	User getUserByEmail(String email);
	
	boolean registerUser(User u);

}
