package Connection;

import org.apache.log4j.Logger;
import Config.Settings.DBSettings;
import Exceptions.PoolException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingDeque;

public class ConnectionPool {
    static Logger logger = Logger.getLogger(ConnectionPool.class.getName());
    /**
     * Struct for storage connections
     */
    static LinkedBlockingDeque<Connection> connections;
    /**
     * Connection poll instance
     */
    private static ConnectionPool connectionPool;
    /**
     * Constructor of connection poll object
     * @param connectionCount connections count
     */
    private ConnectionPool(int connectionCount) {
        try {
            connections = new LinkedBlockingDeque<Connection>();

            for (int i = 0; i < connectionCount; i++) {
                connections.add(createConnection());
            }
        } catch (PoolException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get current connection pool instance. Create poll if not exists
     * @return Connection poll instance
     */
    public static ConnectionPool getConnectionPool() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool(5);
        }
        return connectionPool;
    }

    /**
     * Close connections of poll
     * @throws PoolException
     */
    public static void closeConnections() throws PoolException {
        try {
            int size = connections.size();

            for (int i = 0; i < size; i++) {
                connections.getFirst().close();
                connections.pollFirst();
            }
            logger.info("Connections closed.");
        } catch (SQLException e) {
            throw new PoolException(e.getMessage(), e);
        }
    }

    /**
     * Create database connection
     * @return database connections
     * @throws PoolException
     */
    private Connection createConnection() throws PoolException {
        try {
            logger.info("Connection created");

            return DriverManager.getConnection(DBSettings.URL, DBSettings.USERNAME, DBSettings.PASSWORD);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new PoolException(e.getMessage(), e);
        }
    }

    /**
     * Get database connection
     * @return database connection
     * @throws PoolException
     */
    public synchronized Connection getConnection() throws PoolException {
        try {
            logger.info("Ping connection");
            return connections.take();
        } catch (InterruptedException e) {
            throw new PoolException(e.getMessage(), e);
        }
    }

    /**
     * Free database connection
     * @param connection database connection
     */
    public synchronized void freeConnection(Connection connection) {
        if (connection != null) {
            logger.info("Connection good!");
            connections.add(connection);
        }
    }
}
