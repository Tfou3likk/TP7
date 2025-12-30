package fr.univ.tours.jakartaee.tp5.tp5ejb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.annotation.PreDestroy;
import jakarta.ejb.PostActivate;

public abstract class AbstractDAO {

    // à utiliser avec une BDD sous MySQL
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/vinylmarket";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // à utiliser avec une BDD sous H2
    // private static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"; // pour une BDD qui se réinitialise à chaque démarrage
    // private static final String JDBC_URL = "jdbc:h2:file:~/JEE-data/tp.db;DB_CLOSE_DELAY=-1"; // pour une BDD enregistrée dans un fichier à la racine de votre session
    // private static final String USERNAME = "sa";
    // private static final String PASSWORD = "";
    // private static final String DRIVER = "org.h2.Driver";

    protected Connection jdbcConnection;
    
    @PostActivate
    public void connect() {
        try {
            if (jdbcConnection == null || jdbcConnection.isClosed()) {
                try {
                    Class.forName(DRIVER);
                } catch (ClassNotFoundException e) {
                    throw new SQLException(e);
                }
                jdbcConnection = DriverManager.getConnection(
                       JDBC_URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @PreDestroy
    public void disconnect() {
        try {
            if (jdbcConnection != null && !jdbcConnection.isClosed()) {
                jdbcConnection.close();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
