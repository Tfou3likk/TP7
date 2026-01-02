package fr.univ.tours.jakartaee.tp7.business.impl;

import org.springframework.stereotype.Service;

import fr.univ.tours.jakartaee.tp7.business.ConnectionService;
import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import fr.univ.tours.jakartaee.tp7.dao.UserDao;
import fr.univ.tours.jakartaee.tp7.dao.impl.UserDaoImpl;
import fr.univ.tours.jakartaee.tp7.entities.UserEntity;



public class ConnectionServiceImpl implements ConnectionService {
	
	
	private UserDao userDao;
	
	public ConnectionServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserEntity connect(String email){
		UserEntity user = null;
		if(!email.isEmpty() && !email.isBlank()) {
			user = userDao.getUserByEmail(email);
			if(user != null) {
				return user;
			}
		}
		return user;
		
		
	}
	
	public UserEntity register(UserEntity user) {
		
		if(userDao.getUserByEmail(user.getEmail()) == null) {
			userDao.registerUser(user);
			return user;
		}
		 return null;
		
	}

}
