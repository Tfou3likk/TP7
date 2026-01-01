package fr.univ.tours.jakartaee.tp7.dao;

import fr.univ.tours.jakartaee.tp7.business.pojo.User;



public interface UserDao {

    // TODO to implement
	User getUserByEmail(String email);
	
	boolean registerUser(User u);

}
