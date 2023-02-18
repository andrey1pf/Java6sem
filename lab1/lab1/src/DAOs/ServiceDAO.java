package DAOs;

import Config.schemes.SqlDelete;
import Config.schemes.SqlInsert;
import Config.schemes.SqlSelection;
import Connection.JdbcConnector;
import Entities.Orders;
import Entities.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceDAO implements DAO<Service>{
    Connection connection;

    public ServiceDAO(){
        connection = JdbcConnector.getConnection();
    }

    @Override
    public Optional<Service> get(int id) {
        try {
            String sql = SqlSelection.selectServiceById;
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Service> getAll() {
        try{
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Service> getService(int id){
        try {
            String sql = SqlSelection.selectOrdersById;
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

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Service service) {
        try {
            PreparedStatement statement = connection.prepareStatement(SqlInsert.insertService);
            statement.setString(1, service.getDescriptionService());
            statement.setInt(2, service.getQualificationService());
            statement.setInt(3, service.getAmountWorkersService());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Service service, String[] params) {

    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SqlDelete.deleteService);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
