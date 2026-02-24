package com.usermanager;

import java.sql.*;

public class UserDao {
    UserController userController = new UserController();
    public void getAll() {
        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet result = stmt.executeQuery("select * from users")) {

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                System.out.printf("""
                        id = %d
                        name = %s
                        email = %s

                        """, id, name, email);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();

        }
    }

    public void addUser(String name, String email) {
        String query = "insert into users(name, email) values(?, ?)";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);

            stmt.executeUpdate();
            System.out.println("User added successfully");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
