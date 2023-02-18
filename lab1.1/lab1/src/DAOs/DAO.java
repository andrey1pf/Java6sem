package DAOs;

import Exceptions.DAOException;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    /**
     * Method of getting an object
     * @param id object id
     * @return object of type T
     */
    Optional<T> get(int id) throws DAOException;

    /**
     * Method of getting an objects
     * @return object list of type T
     */
    List<T> getAll() throws DAOException;

    /**
     * Object insertion method
     * @param t object of type T
     */
    void insert(T t) throws DAOException;

    /**
     * Object updating method
     * @param t object of type T
     * @param params other params
     */
    void update(T t, String[] params) throws DAOException;

    /**
     * Object deleting method
     * @param t object of type T
     */
    void delete(int t) throws DAOException;
}
