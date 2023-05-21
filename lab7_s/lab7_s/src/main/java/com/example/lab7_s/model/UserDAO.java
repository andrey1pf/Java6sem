package com.example.lab7_s.model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lab7";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "pi31415926";

    public User getUserById(int id) {
        User user = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                user = new User(id, name, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @GetMapping("/h")
    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                User user = new User(id, name, email);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void addUser(User user) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name, email) VALUES (?, ?)")) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("UPDATE users SET name = ?, email = ? WHERE id = ?")) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
