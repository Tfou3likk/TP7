package fr.univ.tours.jakartaee.tp7.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.univ.tours.jakartaee.tp7.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp7.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp7.dao.AddDiskDAO;
import fr.univ.tours.jakartaee.tp7.entities.DiskEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class AddDiskDAOImpl implements AddDiskDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<DiskEntity> listAllDisk() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT disk FROM DiskEntity disk", DiskEntity.class).getResultList();
	}

	@Override
	public DiskEntity getDiskById(String diskId) {
		// TODO Auto-generated method stub
		return em.find(DiskEntity.class, diskId);
	}

	@Override
	public void addDisk(DiskEntity disk) {
		// TODO Auto-generated method stub
		em.persist(disk);
		
	}

}
