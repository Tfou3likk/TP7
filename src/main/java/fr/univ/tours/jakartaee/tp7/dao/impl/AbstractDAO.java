package fr.univ.tours.jakartaee.tp7.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractDAO {

    public final JdbcTemplate jdbcTemplate;
    
    

    protected AbstractDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        
        
    }
    
   
        

}
