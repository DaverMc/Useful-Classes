package de.daver.utils.sql;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnector {

    Connection connect() throws SQLException;
}
