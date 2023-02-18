package DAOs;

import Config.schemes.SqlDelete;
import Config.schemes.SqlInsert;
import Config.schemes.SqlSelection;
import Connection.JdbcConnector;
import Entities.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrdersDAO implements DAO<Orders>{
    Connection connection;

    public OrdersDAO(){
        connection = JdbcConnector.getConnection();
    }
    @Override
    public Optional<Orders> get(int id) {
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

            return Optional.ofNullable(order);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Orders> getAll() {
        try{
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Orders> getNoPaidOrders(){
        try{
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Orders> getAllById(int id) {
        try{
            String sql = SqlSelection.selectAllOrdersById;
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Orders orders) {
        try {
            PreparedStatement statement = connection.prepareStatement(SqlInsert.insertOrder);
            statement.setInt(1, orders.getId_customer());
            statement.setInt(2, orders.getId_task());
            statement.setFloat(3, orders.getPrice());
            statement.setInt(4, orders.getPaid());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Orders orders, String[] params) {

    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SqlDelete.deleteOrder);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
