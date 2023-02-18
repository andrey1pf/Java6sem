package DAOs;

import Config.schemes.SqlDelete;
import Config.schemes.SqlInsert;
import Config.schemes.SqlSelection;
import Config.schemes.SqlUpdate;
import Connection.JdbcConnector;
import Entities.Workers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorkersDAO implements DAO<Workers>{
    Connection connection;

    public WorkersDAO(){
        connection = JdbcConnector.getConnection();
    }
    /**
     * Method of getting an object
     *
     * @param id object id
     * @return object of type T
     */
    @Override
    public Optional<Workers> get(int id) {
        try {
            String sql = SqlSelection.selectWorkerById;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            Workers worker = null;
            while (result.next()) {
                worker = new Workers(
                        result.getInt("id"),
                        result.getInt("qualification"),
                        result.getFloat("salary"),
                        result.getInt("employment")
                );
            }

            return Optional.ofNullable(worker);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method of getting an objects
     *
     * @return object list of type T
     */
    @Override
    public List<Workers> getAll() {
        try{
            ResultSet result = connection.prepareStatement(SqlSelection.selectAllWorkers).executeQuery();

            List<Workers> workers = new ArrayList<Workers>();
            while (result.next()) {
                workers.add(new Workers(
                        result.getInt("id"),
                        result.getInt("qualification"),
                        result.getFloat("salary"),
                        result.getInt("employment")
                ));
            }

            return workers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Object insertion method
     *
     * @param workers object of type T
     */
    @Override
    public void insert(Workers workers) {
        try {
            PreparedStatement statement = connection.prepareStatement(SqlInsert.insertWorker);
            statement.setInt(1, workers.getQualificationWorkers());
            statement.setFloat(2, workers.getSalaryWorkers());
            statement.setInt(3, workers.getEmploymentWorkers());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Object updating method
     *
     * @param workers object of type T
     * @param params  other params
     */
    @Override
    public void update(Workers workers, String[] params) {
    }

    public void updateWorker(int employment, int id){
        try {
            PreparedStatement statement = connection.prepareStatement(SqlUpdate.updateWorkerEmployment);
            statement.setInt(1, employment);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Object deleting method
     *
     * @param id object of type T
     */
    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SqlDelete.deleteWorker);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
