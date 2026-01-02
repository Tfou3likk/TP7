package fr.univ.tours.jakartaee.tp7.business;

import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import fr.univ.tours.jakartaee.tp7.entities.UserEntity;



public interface ConnectionService {
	
	UserEntity connect(String email);
	
	UserEntity register(UserEntity user);

}
