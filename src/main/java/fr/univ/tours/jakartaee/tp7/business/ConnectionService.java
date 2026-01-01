package fr.univ.tours.jakartaee.tp7.business;

import fr.univ.tours.jakartaee.tp7.business.pojo.User;



public interface ConnectionService {
	
	User connect(String email) throws Exception;
	
	User register(User user) throws Exception;

}
