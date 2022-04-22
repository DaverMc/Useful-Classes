package de.daver.utils.sql.connector;

import de.daver.utils.reflect.Reflections;
import de.daver.utils.sql.DatabaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector implements DatabaseConnector {

    private final String url;
    private String userName;
    private String password;

    public MySQLConnector(String address, String dbName){
        this.url = "jdbc:mysql://" + address + "/" + dbName;
    }

    public MySQLConnector setUser(String userName, String password){
        this.userName = userName;
        this.password = password;
        return this;
    }

    @Override
    public Connection connect() throws SQLException {
        Reflections.loadClass("com.mysql.jdbc.Driver");
        if(userName == null) return DriverManager.getConnection(url);
        return DriverManager.getConnection(url, userName, password);
    }
}
