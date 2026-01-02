package fr.univ.tours.jakartaee.tp7.dao.impl;

import fr.univ.tours.jakartaee.tp7.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import fr.univ.tours.jakartaee.tp7.dao.VinylCollectionDAO;
import fr.univ.tours.jakartaee.tp7.entities.DiskEntity;
import fr.univ.tours.jakartaee.tp7.entities.UserEntity;
import fr.univ.tours.jakartaee.tp7.entities.VinylCollectionEntity;
import fr.univ.tours.jakartaee.tp7.entities.id.VinylCollectionEntityId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


public class VinylCollectionDAOImpl implements VinylCollectionDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
    public void addToCollection(UserEntity buyer, Collection<String> diskIds) {
		
		for(String diskId : diskIds) {
			
			DiskEntity disk = new DiskEntity(diskId);
			VinylCollectionEntity vinylCollection = new VinylCollectionEntity(buyer, disk);
			
			em.persist(vinylCollection);
		}
		
    }
    
    public List<DiskEntity> listCollection(UserEntity owner){
    	
    	return em.createQuery("SELECT vc.disk FROM VinylCollectionEntity vc WHERE vc.user = :vcuser ", DiskEntity.class)
    			.setParameter("vcuser", owner).getResultList();
    	
    }

	@Override
	public void addToCollectionbyId(UserEntity owner, String diskId) {
		// TODO Auto-generated method stub
		DiskEntity disk = new DiskEntity(diskId);
		VinylCollectionEntity vinylCollection = new VinylCollectionEntity(owner, disk);
		em.persist(vinylCollection);
	}


}
