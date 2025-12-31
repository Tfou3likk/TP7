package fr.univ.tours.jakartaee.tp6.dao.impl;

import fr.univ.tours.jakartaee.tp6.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp6.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp6.dao.DiskToSoldDAO;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static java.lang.String.format;


public class DiskToSoldDAOImpl extends AbstractDAO implements DiskToSoldDAO {

    protected DiskToSoldDAOImpl(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
		// TODO Auto-generated constructor stub
	}
    
 

	@Override
    public List<DiskToSold> listAll(){
    	
		String requete = "Select d.identification_code, d.album, d.artist, dts.price from disk d natural join disk_to_sold dts";
       return jdbcTemplate.query(requete, rs ->{
    	   List<DiskToSold> listeDts = new ArrayList<>();
    	   while(rs.next()) {
    		  Disk disk = new Disk(rs.getString("identification_code"), rs.getString("album"), rs.getString("artist"));
    		  DiskToSold dts = new DiskToSold(disk, rs.getBigDecimal("price"));
    		  listeDts.add(dts);
    	   }
    	   return listeDts;
       });
		
		
		
		/*PreparedStatement preparedStatement = jdbcConnection.prepareStatement("Select d.identification_code, d.album, d.artist, dts.price from disk d natural join disk_to_sold dts");
        ResultSet resultSet = preparedStatement.executeQuery();
        return getDiskToSolds(resultSet);*/
    }

    @Override
    public List<DiskToSold> listAllByIds(Collection<String> diskIds){
    	
       String requete = """
       SELECT d.identification_code, d.album, d.artist, dts.price 
       from disk d natural join disk_to_sold dts 
       where d.identification_code in (:idts) 
       """;
       NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
       MapSqlParameterSource params = new MapSqlParameterSource();
       params.addValue("idts", diskIds);
       return namedParameterJdbcTemplate.query(requete, params, (rs, rowNum) ->
    	   new DiskToSold(new Disk(rs.getString("identification_code"), rs.getString("album"), rs.getString("artist")), rs.getBigDecimal("price"))
    	   
       );
    	
    	
    	
    	
    	/*ResultSet resultSet = generateInClause(
                    """
                    SELECT d.identification_code, d.album, d.artist, dts.price 
                    from disk d natural join disk_to_sold dts 
                    where d.identification_code in (%s) 
                    """, diskIds).executeQuery();
        return getDiskToSolds(resultSet);*/
    }

    @Override
    public void removeFromMarketplace(Collection<String> diskIds){
       
    	String requete =  """
                DELETE FROM disk_to_sold 
                WHERE identification_code in (:idts) 
                """;
    	NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("idts", diskIds);
        namedParameterJdbcTemplate.update(requete, params);
    	
    	/*generateInClause(
                """
                DELETE FROM disk_to_sold 
                WHERE identification_code in (%s) 
                """, diskIds).executeUpdate();*/
    }

    private List<DiskToSold> getDiskToSolds(ResultSet resultSet) throws SQLException {
        List<DiskToSold> output = new ArrayList<>();
        while(resultSet.next()){
            output.add(new DiskToSold(
                    new Disk(
                            resultSet.getString("identification_code"),
                            resultSet.getString("album"),
                            resultSet.getString("artist")
                    ),
                    resultSet.getBigDecimal("price")
            ));
        }
        return output;
    }

    /*private PreparedStatement generateInClause(String formatedBaseQuery, Collection<String> inClause) throws SQLException {
        PreparedStatement preparedStatement = jdbcConnection.prepareStatement(
                format(formatedBaseQuery, Stream.generate(() -> "?").limit(inClause.size()).collect(Collectors.joining(","))
                )
        );
        AtomicInteger cursor = new AtomicInteger(1);
        inClause.forEach(inValue -> {
            try {
                preparedStatement.setString(cursor.getAndIncrement(), inValue);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return preparedStatement;
    }*/

}
