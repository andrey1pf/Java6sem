package DAOs;

import Config.schemes.SqlDelete;
import Config.schemes.SqlInsert;
import Entities.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Config.schemes.SqlSelection;
import Connection.JdbcConnector;

public class CustomerDAO implements DAO<Customer>{
    Connection connection;

    public CustomerDAO(){
        connection = JdbcConnector.getConnection();
    }

    @Override
    public Optional<Customer> get(int id) {
        try {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> getAll() {
        try{
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Customer customer) {
        try {
            PreparedStatement statement = connection.prepareStatement(SqlInsert.insertCustomer);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getSurname());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Customer customer, String[] params) {}

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SqlDelete.deleteCustomer);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
