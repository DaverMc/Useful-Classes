package de.daver.utils.sql.connector;

import de.daver.utils.reflect.Reflections;
import de.daver.utils.sql.DatabaseConnector;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLLiteConnector implements DatabaseConnector {

    private final String url;

    public SQLLiteConnector(String filePath){
        this.url = "jdbc:sqlite:" + filePath;
    }

    public SQLLiteConnector(File file){
        this(file.getPath());
    }

    @Override
    public Connection connect() throws SQLException {
        Reflections.loadClass("com.sqlite.JDBC");
        return DriverManager.getConnection(this.url);
    }
}
