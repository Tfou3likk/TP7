package fr.univ.tours.jakartaee.tp7.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.univ.tours.jakartaee.tp7.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp7.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp7.dao.AddDiskDAO;

public class AddDiskDAOImpl extends AbstractDAO implements AddDiskDAO {
	
	

	public AddDiskDAOImpl(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Disk> listAllDisk() {
		// TODO Auto-generated method stub
		String requete = "SELECT * FROM disk";
		return jdbcTemplate.query(requete, rs ->{
			List<Disk> listeDisk = new ArrayList<>();
			while(rs.next()) {
				Disk disk = new Disk(rs.getString("identification_code"), rs.getString("album"), rs.getString("artist"));
				listeDisk.add(disk);
			}
			return listeDisk;
 		});
	}

	@Override
	public Disk getDiskById(String diskId) {
		// TODO Auto-generated method stub
		String requete = "SELECT * FROM disk WHERE identification_code = ?";
		return jdbcTemplate.query(requete, rs ->{
			if(rs.next()) {
				return new Disk(rs.getString("identification_code"), rs.getString("album"), rs.getString("artist"));
			}
			return null;
		}, diskId);
	}

	@Override
	public void addDisk(Disk disk) {
		// TODO Auto-generated method stub
		String requete = "INSERT INTO disk(identification_code, album, artist) VALUES (?, ?, ?)";
		jdbcTemplate.update(requete, disk.identificationCode(), disk.album(), disk.artist());
		
	}

}
