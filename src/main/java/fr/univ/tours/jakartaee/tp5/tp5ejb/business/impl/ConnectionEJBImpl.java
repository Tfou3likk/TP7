package fr.univ.tours.jakartaee.tp5.tp5ejb.business.impl;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.ConnectionEJB;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.User;
import fr.univ.tours.jakartaee.tp5.tp5ejb.dao.UserDao;
import fr.univ.tours.jakartaee.tp5.tp5ejb.dao.impl.UserDaoImpl;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class ConnectionEJBImpl implements ConnectionEJB {
	
	@EJB
	UserDao userDao;
	
	public User connect(String email) throws Exception {
		User user = null;
		if(!email.isEmpty() && !email.isBlank()) {
			user = userDao.getUserByEmail(email);
			if(user != null) {
				return user;
			}
		}
		throw new Exception();
		
	}
	
	public User register(User user) throws Exception {
		
		if(userDao.getUserByEmail(user.email()) == null) {
			if(userDao.registerUser(user) == true) {
				return user;
			}
			
			
		}
		throw new Exception();
		
		
	}

}
