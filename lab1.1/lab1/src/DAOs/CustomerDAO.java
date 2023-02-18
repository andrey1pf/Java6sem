package DAOs;

import Config.Schemes.SqlDelete;
import Config.Schemes.SqlInsert;
import Entities.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Config.Schemes.SqlSelection;
import Connection.ConnectionPool;
import Exceptions.DAOException;
import Exceptions.PoolException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CustomerDAO implements DAO<Customer>{

    static Logger logger = Logger.getLogger(CustomerDAO.class.getName());
    ConnectionPool connectionPool;

    /**
     * Customer DAO object constructor
     */
    public CustomerDAO() { connectionPool = ConnectionPool.getConnectionPool(); }

    /**
     * Method of getting an object
     *
     * @param id object id
     * @return object of type T
     */
    @Override
    public Optional<Customer> get(int id) throws DAOException {
        try {
            Connection connection = connectionPool.getConnection();
            String sql = SqlSelection.selectCustomerById;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            Customer customer = null;
            while (result.next()) {
                customer = new Customer(
                        result.getInt("id"),
                        result.getString("surname"),
                        result.getString("name")
                );
            }

            return Optional.ofNullable(customer);
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
    public List<Customer> getAll() throws DAOException{
        try{
            Connection connection = connectionPool.getConnection();
            ResultSet result = connection.prepareStatement(SqlSelection.selectAllCustomers).executeQuery();

            List<Customer> customers = new ArrayList<Customer>();
            while (result.next()) {
                customers.add(new Customer(
                        result.getInt("id"),
                        result.getString("surname"),
                        result.getString("name")
                ));
            }

            return customers;
        } catch (SQLException | PoolException e) {
            logger.info(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
    }
    /**
     * Object insertion method
     *
     * @param customer object of type T
     */
    @Override
    public void insert(Customer customer) throws DAOException{
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlInsert.insertCustomer);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getSurname());
            statement.executeUpdate();

        } catch (SQLException | PoolException e) {
            logger.info(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
    }

    @Override
    public void update(Customer customer, String[] params) throws DAOException {}

    /**
     * Object deleting method
     *
     * @param id object of type T
     */
    @Override
    public void delete(int id) throws DAOException{
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlDelete.deleteCustomer);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            logger.info(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
    }
}
