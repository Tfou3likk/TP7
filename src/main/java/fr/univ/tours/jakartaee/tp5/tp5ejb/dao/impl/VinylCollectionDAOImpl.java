package fr.univ.tours.jakartaee.tp5.tp5ejb.dao.impl;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.User;
import fr.univ.tours.jakartaee.tp5.tp5ejb.dao.VinylCollectionDAO;
import jakarta.ejb.Singleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Singleton
public class VinylCollectionDAOImpl extends AbstractDAO implements VinylCollectionDAO {

    @Override
    public void addToCollection(User buyer, Collection<String> diskIds) throws SQLException {
        PreparedStatement preparedStatement = jdbcConnection.prepareStatement(
                "INSERT INTO vinyl_collection(identification_code,user) VALUES (?,?)"
        );

        diskIds.forEach(diskId -> {
            try {
                preparedStatement.setString(1, diskId);
                preparedStatement.setString(2, buyer.email());
                preparedStatement.addBatch();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        preparedStatement.executeBatch();
    }
    
    public List<Disk> listCollection(User owner){
    	
    	List<Disk> listeDisk = new ArrayList<>();
    	
    	try {
    		connect();
    		String requete = "SELECT * FROM disk d JOIN vinyl_collection v ON d.identification_code = v.identification_code WHERE v.user = ? ";
    		PreparedStatement pst = jdbcConnection.prepareStatement(requete);
    		pst.setString(1, owner.email());
    		ResultSet rs = pst.executeQuery();
    		while(rs.next()) {
    			Disk disk = new Disk(rs.getString("identification_code"), rs.getString("album"), rs.getString("artist"));
    			listeDisk.add(disk);
    		}
    		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return listeDisk;
    }


}
