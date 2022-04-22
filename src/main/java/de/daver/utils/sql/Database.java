package de.daver.utils.sql;

import de.daver.utils.logging.Loggers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    private final DatabaseConnector connector;
    private Connection connection;

    public Database(DatabaseConnector connector){
        this.connector = connector;
    }

    public boolean connect() {
        try {
            this.connection = connector.connect();
            return true;
        }catch (SQLException e){
            Loggers.error(e);
            return false;
        }
    }

    public boolean disconnect(){
        try {
            if(connection.isClosed()) return true;
            connection.close();
            return true;
        }catch (SQLException e){
            Loggers.error(e);
            return false;
        }
    }

    public Connection getConnection(){
        return connection;
    }

    protected void execute(String sqlCommand){
        try(PreparedStatement statement = getConnection().prepareStatement(sqlCommand)){
            statement.execute();
        }catch (SQLException e){
            Loggers.error(e);
        }
    }

    public void execute(SQLCommandBuilder commandBuilder){
        execute(commandBuilder.toString());
    }

    protected ResultSet executeQuery(String sqlCommand){
        try(PreparedStatement statement = getConnection().prepareStatement(sqlCommand)){
            return statement.executeQuery();
        }catch (SQLException e){
            Loggers.error(e);
            return null;
        }
    }

    public ResultSet executeQuery(SQLCommandBuilder commandBuilder){
        return executeQuery(commandBuilder.toString());
    }
}
