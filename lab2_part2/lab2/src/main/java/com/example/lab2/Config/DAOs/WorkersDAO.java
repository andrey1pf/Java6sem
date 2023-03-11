package com.example.lab2.Config.DAOs;

import com.example.lab2.Config.Connection.JPAPI;
import com.example.lab2.Config.Entities.Service;
import com.example.lab2.Config.Schemes.SqlDelete;
import com.example.lab2.Config.Schemes.SqlInsert;
import com.example.lab2.Config.Schemes.SqlSelection;
import com.example.lab2.Config.Schemes.SqlUpdate;
import com.example.lab2.Config.Connection.ConnectionPool;
import com.example.lab2.Config.Entities.Workers;
import com.example.lab2.Config.Exceptions.DAOException;
import com.example.lab2.Config.Exceptions.PoolException;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorkersDAO implements DAO<Workers>{
    static Logger logger = Logger.getLogger(CustomerDAO.class.getName());
    ConnectionPool connectionPool;

    /**
     * Workers DAO object constructor
     */
    public WorkersDAO() { connectionPool = ConnectionPool.getConnectionPool(); }
    /**
     * Method of getting an object
     *
     * @param id object id
     * @return object of type T
     */
    @Override
    public Optional<Workers> get(int id) throws DAOException {
        EntityManager entityManager = null;
        Workers worker = null;

        try {
            entityManager = JPAPI.getEntityManager();
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Workers> criteriaQuery = criteriaBuilder.createQuery(Workers.class);
            Root<Workers> workersRoot = criteriaQuery.from(Workers.class);
            Predicate predicate = criteriaBuilder.equal(workersRoot.get(WorkersCriteria.ID), id);
            criteriaQuery.where(predicate);

            worker = entityManager.createQuery(criteriaQuery).getSingleResult();

            logger.info("Customer was selected by id");

            return Optional.ofNullable(worker);
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
    public List<Workers> getAll() throws DAOException {
        EntityManager entityManager = null;
        Connection connection = null;

        try{
            entityManager = JPAPI.getEntityManager();
            List<Workers> workers = new ArrayList<Workers>();
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Workers> criteriaQuery = criteriaBuilder.createQuery(Workers.class);
            Root<Workers> workersRoot = criteriaQuery.from(Workers.class);

            workers = entityManager.createQuery(criteriaQuery).getResultList();

            logger.info("All customers selected");

            return workers;
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
    }

    /**
     * Object insertion method
     *
     * @param workers object of type T
     */
    @Override
    public void insert(Workers workers) throws DAOException {
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlInsert.insertWorker);
            statement.setInt(1, workers.getQualificationWorkers());
            statement.setFloat(2, workers.getSalaryWorkers());
            statement.setInt(3, workers.getEmploymentWorkers());
            statement.executeUpdate();

        } catch (SQLException | PoolException e) {
            logger.info(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
    }

    /**
     * Object updating method
     *
     * @param workers object of type T
     * @param params  other params
     */
    @Override
    public void update(Workers workers, String[] params) throws DAOException {
    }

    public void updateWorker(int employment, int id){
        EntityManager entityManager = JPAPI.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaUpdate<Workers> update = criteriaBuilder.createCriteriaUpdate(Workers.class);
            Root<Workers> workersRoot = update.from(Workers.class);
            update.set(workersRoot.get(WorkersCriteria.EMPLOYMENT), employment);
            Predicate condition = criteriaBuilder.equal(workersRoot.get(WorkersCriteria.ID), id);
            update.where(condition);

            transaction.begin();
            entityManager.createQuery(update).executeUpdate();
            transaction.commit();

            logger.info("Worker update");
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
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
            PreparedStatement statement = connection.prepareStatement(SqlDelete.deleteWorker);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException | PoolException e) {
            logger.info(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
    }
}
