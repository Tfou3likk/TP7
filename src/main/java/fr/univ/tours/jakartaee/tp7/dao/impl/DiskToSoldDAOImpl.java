package fr.univ.tours.jakartaee.tp7.dao.impl;


import fr.univ.tours.jakartaee.tp7.dao.DiskToSoldDAO;
import fr.univ.tours.jakartaee.tp7.entities.DiskToSoldEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Collection;
import java.util.List;






public class DiskToSoldDAOImpl implements DiskToSoldDAO {
	
	@PersistenceContext
    private EntityManager em;
    
 

	@Override
	public List<DiskToSoldEntity> listAll(){
    	
		return em.createQuery("SELECT dts FROM DiskToSoldEntity dts", DiskToSoldEntity.class).getResultList();
		
    }

    @Override
    public List<DiskToSoldEntity> listAllByIds(Collection<String> diskIds){
    	
    	if(diskIds.isEmpty()) {
    		return List.of();
    	}
    	
    	return em.createQuery("SELECT dts FROM DiskToSoldEntity dts WHERE dts.identificationCode IN :idts", DiskToSoldEntity.class)
    			.setParameter("idts", diskIds).getResultList();
       
    }

    @Override
    public void removeFromMarketplace(Collection<String> diskIds){
       
    	em.createQuery("DELETE FROM DiskToSoldEntity dts WHERE dts.identificationCode IN :idts")
    			.setParameter("idts", diskIds).executeUpdate();
    }

    

}
