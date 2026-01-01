package fr.univ.tours.jakartaee.tp7.dao.impl;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import fr.univ.tours.jakartaee.tp7.dao.UserDao;



public class UserDaoImpl extends AbstractDAO implements UserDao {

    // TODO to implement
	
	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
		// TODO Auto-generated constructor stub
	}

	public User getUserByEmail(String email) {
		
		String requete = "SELECT * FROM user WHERE email = ?";
		return jdbcTemplate.query(requete, rs -> {
			if(rs.next()) {
				return new User(rs.getString("email"), rs.getString("firstname"), rs.getString("lastname"));
			}
			return null;
		}, email);
			
			/*PreparedStatement pst = jdbcConnection.prepareStatement(requete);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			rs.next();
			if(rs.getString("email") != null) {
				user = new User(rs.getString("email"), rs.getString("firstname"), rs.getString("lastname"));
			}*/
			
			
			
		
	}
	
	public boolean registerUser(User u) {
		
		
			
			String requete = "INSERT INTO user(email, firstname, lastname) VALUES (?, ?, ?)";
			int register = jdbcTemplate.update(requete, u.email(), u.firstName(), u.lastName());
			if (register == 1) {
				return true;
			}else {
				return false;
			}
			
			
			/*PreparedStatement pst = jdbcConnection.prepareStatement(requete);
			pst.setString(1, u.email());
			pst.setString(2, u.firstName());
			pst.setString(3, u.lastName());
			register = pst.executeUpdate();*/
			
			
			
		
	}

}
