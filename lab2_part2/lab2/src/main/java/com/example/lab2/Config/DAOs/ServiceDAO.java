package com.example.lab2.Config.DAOs;

import com.example.lab2.Config.Connection.JPAPI;
import com.example.lab2.Config.Entities.Customer;
import com.example.lab2.Config.Schemes.SqlDelete;
import com.example.lab2.Config.Schemes.SqlInsert;
import com.example.lab2.Config.Schemes.SqlSelection;
import com.example.lab2.Config.Connection.ConnectionPool;
import com.example.lab2.Config.Entities.Orders;
import com.example.lab2.Config.Entities.Service;
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
        EntityManager entityManager = null;
        Service service = null;

        try {
            entityManager = JPAPI.getEntityManager();
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Service> criteriaQuery = criteriaBuilder.createQuery(Service.class);
            Root<Service> serviceRoot = criteriaQuery.from(Service.class);
            Predicate predicate = criteriaBuilder.equal(serviceRoot.get(ServiceCriteria.ID), id);
            criteriaQuery.where(predicate);

            service = entityManager.createQuery(criteriaQuery).getSingleResult();

            logger.info("Customer was selected by id");

            return Optional.ofNullable(service);
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
    public List<Service> getAll() throws DAOException {
        EntityManager entityManager = null;
        Connection connection = null;
        try{
            entityManager = JPAPI.getEntityManager();
            List<Service> services = new ArrayList<Service>();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Service> criteriaQuery = criteriaBuilder.createQuery(Service.class);
            Root<Service> serviceRoot = criteriaQuery.from(Service.class);

            services = entityManager.createQuery(criteriaQuery).getResultList();

            logger.info("All customers selected");

            return services;
        } catch (Exception e) {
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
        EntityManager entityManager = null;
        Connection connection = null;
        Service service = null;

        try {
            entityManager = JPAPI.getEntityManager();
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Service> criteriaQuery = criteriaBuilder.createQuery(Service.class);
            Root<Service> serviceRoot = criteriaQuery.from(Service.class);
            Predicate predicate = criteriaBuilder.equal(serviceRoot.get(ServiceCriteria.ID), id);
            criteriaQuery.where(predicate);

            service = entityManager.createQuery(criteriaQuery).getSingleResult();

            return Optional.ofNullable(service);

        } catch (Exception e) {
            logger.info(e.getMessage());
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
