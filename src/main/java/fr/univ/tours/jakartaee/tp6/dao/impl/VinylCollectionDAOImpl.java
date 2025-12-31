package fr.univ.tours.jakartaee.tp6.dao.impl;

import fr.univ.tours.jakartaee.tp6.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp6.business.pojo.User;
import fr.univ.tours.jakartaee.tp6.dao.VinylCollectionDAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


public class VinylCollectionDAOImpl extends AbstractDAO implements VinylCollectionDAO {

    protected VinylCollectionDAOImpl(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void addToCollection(User buyer, Collection<String> diskIds) throws SQLException {
        
		String requete = "INSERT INTO vinyl_collection(identification_code,user) VALUES (?,?)";
		jdbcTemplate.batchUpdate(requete, diskIds, diskIds.size(), (ps, diskId)->{
			ps.setString(1, diskId);
			ps.setString(2, buyer.email());
		});
		
		
		
		
		
		
		
		
		
		
		
		/*PreparedStatement preparedStatement = jdbcConnection.prepareStatement(
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

        preparedStatement.executeBatch();*/
    }
    
    public List<Disk> listCollection(User owner){
    	
    	List<Disk> listeDisk = new ArrayList<>();
    	String requete = "SELECT * FROM disk d JOIN vinyl_collection v ON d.identification_code = v.identification_code WHERE v.user = ? ";
    	return jdbcTemplate.query(requete, rs -> {
    		while(rs.next()) {
    			Disk disk = new Disk(rs.getString("identification_code"), rs.getString("album"), rs.getString("artist"));
        		listeDisk.add(disk);
    		}
    		return listeDisk;
    	}, owner.email());
    	
    		
    		
    	
    	
    	
    	/*String requete = "SELECT * FROM disk d JOIN vinyl_collection v ON d.identification_code = v.identification_code WHERE v.user = ? ";
    	PreparedStatement pst = jdbcConnection.prepareStatement(requete);
    	pst.setString(1, owner.email());
    	ResultSet rs = pst.executeQuery();
    	while(rs.next()) {
    		Disk disk = new Disk(rs.getString("identification_code"), rs.getString("album"), rs.getString("artist"));
    		listeDisk.add(disk);
    	}*/
    		
    	
    	
    	
    	
    }


}
