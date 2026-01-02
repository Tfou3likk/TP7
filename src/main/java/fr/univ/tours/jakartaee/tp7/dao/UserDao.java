package fr.univ.tours.jakartaee.tp7.dao;

import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import fr.univ.tours.jakartaee.tp7.entities.UserEntity;



public interface UserDao {

    // TODO to implement
	UserEntity getUserByEmail(String email);
	
	void registerUser(UserEntity u);

}
