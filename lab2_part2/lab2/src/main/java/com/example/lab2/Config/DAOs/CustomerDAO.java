package com.example.lab2.Config.DAOs;

import com.example.lab2.Config.Connection.ConnectionPool;
import com.example.lab2.Config.Connection.JPAPI;
import com.example.lab2.Config.Entities.Customer;
import com.example.lab2.Config.Exceptions.DAOException;
import com.example.lab2.Config.Exceptions.PoolException;
import com.mysql.cj.Session;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        EntityManager entityManager = null;
        Customer customer = null;
        try {
            entityManager = JPAPI.getEntityManager();
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
            Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
            Predicate predicate = criteriaBuilder.equal(customerRoot.get(CustomerCriteria.ID), id);
            criteriaQuery.where(predicate);

            customer = entityManager.createQuery(criteriaQuery).getSingleResult();

            logger.info("Customer was selected by id");
            return Optional.ofNullable(customer);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        } finally {
            if(entityManager != null) {
                entityManager.close();
            }
        }
    }

    /**
     * Method of getting an objects
     *
     * @return object list of type T
     */
    @Override
    public List<Customer> getAll() throws DAOException{
        EntityManager entityManager = null;
        Connection connection = null;
        try{
            entityManager = JPAPI.getEntityManager();
            List<Customer> customers = new ArrayList<Customer>();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
            Root<Customer> customerRoot = criteriaQuery.from(Customer.class);

            customers = entityManager.createQuery(criteriaQuery).getResultList();

            logger.info("All customers selected");
            return customers;
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        } finally {
            if (entityManager != null) entityManager.close();
        }
    }
    /**
     * Object insertion method
     *
     * @param customer object of type T
     */
    @Override
    public void insert(Customer customer) throws DAOException{

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

    }
}
