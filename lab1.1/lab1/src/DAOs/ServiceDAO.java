package DAOs;

import Config.Schemes.SqlDelete;
import Config.Schemes.SqlInsert;
import Config.Schemes.SqlSelection;
import Entities.Orders;
import Entities.Service;
import Exceptions.DAOException;
import Exceptions.PoolException;
import org.apache.log4j.Logger;
import Connection.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceDAO implements DAO<Service>{
    static Logger logger = Logger.getLogger(CustomerDAO.class.getName());
    ConnectionPool connectionPool;

    /**
     * Service DAO object constructor
     */
    public ServiceDAO() { connectionPool = ConnectionPool.getConnectionPool(); }

    /**
     * Method of getting an object
     *
     * @param id object id
     * @return object of type T
     */
    @Override
    public Optional<Service> get(int id) throws DAOException {

        try {
            String sql = SqlSelection.selectServiceById;
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            Service service = null;
            while (result.next()) {
                service = new Service(
                        result.getInt("id"),
                        result.getString("description"),
                        result.getInt("qualification"),
                        result.getInt("amount_workers")
                );
            }

            return Optional.ofNullable(service);
        } catch (SQLException | PoolException e) {
            logger.info(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
    }

    /**
     * Method of getting an objects
     *
     * @return object list of type T
     */
    @Override
    public List<Service> getAll() throws DAOException {
        try{
            Connection connection = connectionPool.getConnection();
            ResultSet result = connection.prepareStatement(SqlSelection.selectAllServices).executeQuery();

            List<Service> services = new ArrayList<Service>();
            while (result.next()) {
                services.add(new Service(
                        result.getInt("id"),
                        result.getString("description"),
                        result.getInt("qualification"),
                        result.getInt("amount_workers")
                ));
            }

            return services;
        } catch (SQLException | PoolException e) {
            logger.info(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
    }

    /**
     * Object insertion method
     *
     * @param id id object of type T
     */
    public Optional<Service> getService(int id){
        try {
            String sql = SqlSelection.selectOrdersById;
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            Orders order = null;
            while (result.next()) {
                order = new Orders(
                        result.getInt("id"),
                        result.getInt("id_customer"),
                        result.getInt("id_task"),
                        result.getFloat("price"),
                        result.getInt("paid")
                );
            }

            int id_task = order.getId_task();

            return get(id_task);

        } catch (SQLException | PoolException e) {
            logger.info(e.getMessage());
            throw new RuntimeException(e);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Object insertion method
     *
     * @param service object of type T
     */
    @Override
    public void insert(Service service) throws DAOException {
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlInsert.insertService);
            statement.setString(1, service.getDescriptionService());
            statement.setInt(2, service.getQualificationService());
            statement.setInt(3, service.getAmountWorkersService());
            statement.executeUpdate();

        } catch (SQLException | PoolException e) {
            logger.info(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
    }

    @Override
    public void update(Service service, String[] params) throws DAOException {

    }

    /**
     * Object deleting method
     *
     * @param id object of type T
     */

    @Override
    public void delete(int id) throws DAOException {
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlDelete.deleteService);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            logger.info(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
    }
}
