package com.usermanager;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    public ArrayList<User> getAll() {
        ArrayList<User> usersList = new ArrayList<>();
        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet result = stmt.executeQuery("select * from users")) {


            while (result.next()) {
                usersList.add(new User(result.getInt("id"),
                        result.getString("name"),
                        result.getString("email")));
            }
            return usersList;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getById(int id) {
        String query = "select * from users where id = ?;";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                return new User(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("email")
                );
            } else
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean addUser(User user) {
        String query = "insert into users(name, email) values(?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());

            int change = stmt.executeUpdate();
            return change > 0;

        } catch (SQLException e) {
            return false;

        }
    }

    public boolean updateUser(User user) {
        String query = "update users set name = ?, email = ? where id = ?;";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getId());

            int change = stmt.executeUpdate();
            return change > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteUser(int id) {
        String query = "delete from users  where id = ?;";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);

            int change = stmt.executeUpdate();
            return change > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
