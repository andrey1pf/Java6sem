package DAOs;

import Config.Schemes.SqlDelete;
import Config.Schemes.SqlInsert;
import Config.Schemes.SqlSelection;
import Entities.Orders;
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

public class OrdersDAO implements DAO<Orders>{
    static Logger logger = Logger.getLogger(CustomerDAO.class.getName());
    ConnectionPool connectionPool;

    /**
     * Orders DAO object constructor
     */
    public OrdersDAO() { connectionPool = ConnectionPool.getConnectionPool(); }
    /**
     * Method of getting an object
     *
     * @param id object id
     * @return object of type T
     */
    @Override
    public Optional<Orders> get(int id) throws DAOException {
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

            return Optional.ofNullable(order);
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
    public List<Orders> getAll() throws DAOException{
        try{
            Connection connection = connectionPool.getConnection();
            ResultSet result = connection.prepareStatement(SqlSelection.selectAllOrders).executeQuery();

            List<Orders> orders = new ArrayList<Orders>();
            while (result.next()) {
                orders.add(new Orders(
                        result.getInt("id"),
                        result.getInt("id_customer"),
                        result.getInt("id_task"),
                        result.getFloat("price"),
                        result.getInt("paid")
                ));
            }

            return orders;
        } catch (SQLException | PoolException e) {
            logger.info(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
    }

    /**
     * Object insertion method
     *
     * @return list of objects
     */
    public List<Orders> getNoPaidOrders(){
        try{
            Connection connection = connectionPool.getConnection();
            ResultSet result = connection.prepareStatement(SqlSelection.selectNoPaidOrders).executeQuery();

            List<Orders> orders = new ArrayList<Orders>();
            while (result.next()) {
                orders.add(new Orders(
                        result.getInt("id"),
                        result.getInt("id_customer"),
                        result.getInt("id_task"),
                        result.getFloat("price"),
                        result.getInt("paid")
                ));
            }

            return orders;
        } catch (SQLException | PoolException e) {
            logger.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }


    /**
     * Object insertion method
     *
     * @param id id object of type T
     */
    public List<Orders> getAllById(int id) {
        try{
            String sql = SqlSelection.selectAllOrdersById;
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            List<Orders> orders = new ArrayList<Orders>();
            while (result.next()) {
                orders.add(new Orders(
                        result.getInt("id"),
                        result.getInt("id_customer"),
                        result.getInt("id_task"),
                        result.getFloat("price"),
                        result.getInt("paid")
                ));
            }

            return orders;
        } catch (SQLException | PoolException e) {
            logger.info(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Object insertion method
     *
     * @param orders object of type T
     */
    @Override
    public void insert(Orders orders) throws DAOException{
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlInsert.insertOrder);
            statement.setInt(1, orders.getId_customer());
            statement.setInt(2, orders.getId_task());
            statement.setFloat(3, orders.getPrice());
            statement.setInt(4, orders.getPaid());
            statement.executeUpdate();

        } catch (SQLException | PoolException e) {
            logger.info(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
    }

    @Override
    public void update(Orders orders, String[] params) throws DAOException{

    }
    /**
     * Object deleting method
     *
     * @param id object of type T
     */
    @Override
    public void delete(int id) throws DAOException{
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlDelete.deleteOrder);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            logger.info(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
    }
}
