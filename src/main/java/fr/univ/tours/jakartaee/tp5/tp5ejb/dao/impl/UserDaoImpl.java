package fr.univ.tours.jakartaee.tp5.tp5ejb.dao.impl;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.User;
import fr.univ.tours.jakartaee.tp5.tp5ejb.dao.UserDao;
import jakarta.ejb.Singleton;

@Singleton
public class UserDaoImpl extends AbstractDAO implements UserDao {

    // TODO to implement
	
	public User getUserByEmail(String email) {
		
		User user = null;
		try {
			connect();
			String requete = "SELECT * FROM user WHERE email = ?";
			PreparedStatement pst = jdbcConnection.prepareStatement(requete);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			rs.next();
			if(rs.getString("email") != null) {
				user = new User(rs.getString("email"), rs.getString("firstname"), rs.getString("lastname"));
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public boolean registerUser(User u) {
		
		int register = 0;
		try {
			connect();
			String requete = "INSERT INTO user(email, firstname, lastname) VALUES (?, ?, ?)";
			PreparedStatement pst = jdbcConnection.prepareStatement(requete);
			pst.setString(1, u.email());
			pst.setString(2, u.firstName());
			pst.setString(3, u.lastName());
			register = pst.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(register == 1) {
			return true;
		}else {
			return false;
		}
	}

}
