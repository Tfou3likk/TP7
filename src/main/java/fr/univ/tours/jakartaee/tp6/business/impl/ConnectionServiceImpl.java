package fr.univ.tours.jakartaee.tp6.business.impl;

import org.springframework.stereotype.Service;

import fr.univ.tours.jakartaee.tp6.business.ConnectionService;
import fr.univ.tours.jakartaee.tp6.business.pojo.User;
import fr.univ.tours.jakartaee.tp6.dao.UserDao;
import fr.univ.tours.jakartaee.tp6.dao.impl.UserDaoImpl;


@Service
public class ConnectionServiceImpl implements ConnectionService {
	
	
	private UserDao userDao;
	
	public ConnectionServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
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
