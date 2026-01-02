package fr.univ.tours.jakartaee.tp7.dao.impl;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import fr.univ.tours.jakartaee.tp7.dao.UserDao;
import fr.univ.tours.jakartaee.tp7.entities.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;



public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;
	


	public UserEntity getUserByEmail(String email) {
		
		return em.find(UserEntity.class, email);
	}
	
	public void registerUser(UserEntity u) {
		
		em.persist(u);	
	}

}
