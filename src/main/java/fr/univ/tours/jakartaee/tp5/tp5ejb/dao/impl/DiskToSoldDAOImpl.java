package fr.univ.tours.jakartaee.tp5.tp5ejb.dao.impl;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp5.tp5ejb.dao.DiskToSoldDAO;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Singleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;

@Singleton
public class DiskToSoldDAOImpl extends AbstractDAO implements DiskToSoldDAO {

    @Override
    public List<DiskToSold> listAll() throws SQLException {
    	connect();
        PreparedStatement preparedStatement = jdbcConnection.prepareStatement("Select d.identification_code, d.album, d.artist, dts.price from disk d natural join disk_to_sold dts");
        ResultSet resultSet = preparedStatement.executeQuery();
        return getDiskToSolds(resultSet);
    }

    @Override
    public List<DiskToSold> listAllByIds(Collection<String> diskIds) throws SQLException {
    	connect();
        ResultSet resultSet = generateInClause(
                    """
                    SELECT d.identification_code, d.album, d.artist, dts.price 
                    from disk d natural join disk_to_sold dts 
                    where d.identification_code in (%s) 
                    """, diskIds).executeQuery();
        return getDiskToSolds(resultSet);
    }

    @Override
    public void removeFromMarketplace(Collection<String> diskIds) throws SQLException {
        generateInClause(
                """
                DELETE FROM disk_to_sold 
                WHERE identification_code in (%s) 
                """, diskIds).executeUpdate();
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

    private PreparedStatement generateInClause(String formatedBaseQuery, Collection<String> inClause) throws SQLException {
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
    }

}
