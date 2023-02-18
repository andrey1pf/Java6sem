package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Config.settings.DBSettings;


public class JdbcConnector {
    private static final String url = DBSettings.URL;
    private static final String user = DBSettings.USERNAME;
    private static final String password = DBSettings.PASSWORD;

    // JDBC variables for opening and managing connection
    private static Connection con;

    public static Connection getConnection(){
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return null;
    }
}
