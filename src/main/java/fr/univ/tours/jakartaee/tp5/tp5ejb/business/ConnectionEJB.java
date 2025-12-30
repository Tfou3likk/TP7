package fr.univ.tours.jakartaee.tp5.tp5ejb.business;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.User;
import jakarta.ejb.Local;

@Local
public interface ConnectionEJB {
	
	User connect(String email) throws Exception;
	
	User register(User user) throws Exception;

}
