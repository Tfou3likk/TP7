package fr.univ.tours.jakartaee.tp6.dao;

import fr.univ.tours.jakartaee.tp6.business.pojo.User;



public interface UserDao {

    // TODO to implement
	User getUserByEmail(String email);
	
	boolean registerUser(User u);

}
