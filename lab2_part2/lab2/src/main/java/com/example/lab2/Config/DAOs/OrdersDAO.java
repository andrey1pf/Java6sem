package com.example.lab2.Config.DAOs;

import com.example.lab2.Config.Entities.Customer;
import com.example.lab2.Config.Schemes.SqlDelete;
import com.example.lab2.Config.Schemes.SqlInsert;
import com.example.lab2.Config.Schemes.SqlSelection;
import com.example.lab2.Config.Connection.ConnectionPool;
import com.example.lab2.Config.Connection.JPAPI;
import com.example.lab2.Config.Entities.Orders;
import com.example.lab2.Config.Exceptions.DAOException;
import com.example.lab2.Config.Exceptions.PoolException;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        EntityManager entityManager = null;
        Orders orders = null;
        try {
            entityManager = JPAPI.getEntityManager();
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Orders> criteriaQuery = criteriaBuilder.createQuery(Orders.class);
            Root<Orders> ordersRoot = criteriaQuery.from(Orders.class);
            Predicate predicate = criteriaBuilder.equal(ordersRoot.get(OrdersCriteria.ID), id);
            criteriaQuery.where(predicate);

            orders = entityManager.createQuery(criteriaQuery).getSingleResult();

            logger.info("Orders was selected by id");

            return Optional.ofNullable(orders);
        } catch (Exception e) {
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
        EntityManager entityManager = null;
        Connection connection = null;

        try{
            entityManager = JPAPI.getEntityManager();
            List<Orders> orders = new ArrayList<Orders>();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Orders> criteriaQuery = criteriaBuilder.createQuery(Orders.class);
            Root<Orders> ordersRoot = criteriaQuery.from(Orders.class);

            orders = entityManager.createQuery(criteriaQuery).getResultList();

            logger.info("All orders selected");

            return orders;
        } catch (Exception e) {
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
        EntityManager entityManager = null;

        try{
            entityManager = JPAPI.getEntityManager();
            List<Orders> result = new ArrayList<Orders>();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Orders> criteriaQuery = criteriaBuilder.createQuery(Orders.class);
            Root<Orders> ordersRoot = criteriaQuery.from(Orders.class);

            Predicate predicate = criteriaBuilder.equal(ordersRoot.get(OrdersCriteria.PAID), 0);
            criteriaQuery.where(predicate);

            result = entityManager.createQuery(criteriaQuery).getResultList();

            return result;
        } catch (Exception e) {
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
        EntityManager entityManager = null;

        try{
            entityManager = JPAPI.getEntityManager();
            List<Orders> result = new ArrayList<Orders>();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Orders> criteriaQuery = criteriaBuilder.createQuery(Orders.class);
            Root<Orders> ordersRoot = criteriaQuery.from(Orders.class);

            Predicate predicate = criteriaBuilder.equal(ordersRoot.get(OrdersCriteria.ID_CUSTOMER), id);
            criteriaQuery.where(predicate);

            result = entityManager.createQuery(criteriaQuery).getResultList();

            return result;
        } catch (Exception e) {
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
