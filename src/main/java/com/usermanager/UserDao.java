package com.usermanager;

import java.sql.*;

public class UserDao {
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

    public void getById(int id) {
        String query = "select * from users where id = ?;";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                int userId = result.getInt("id");
                String name = result.getString("name");
                String email = result.getString("email");
                System.out.printf("""
                        id = %d
                        name = %s
                        email = %s

                        """, userId, name, email);
            }else
                System.out.println("user not exist");
        } catch (SQLException e) {
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

    public void updateUser(User user){
        String query = "update users set name = ?, email = ? where id = ?;";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(query)){

            stmt.setString(1,user.getName());
            stmt.setString(2,user.getEmail());
            stmt.setInt(3,user.getId());

            int change = stmt.executeUpdate();
            if (change > 0)
                System.out.println("User updated successfully");
            else
                System.out.println("User not exist, check users id by option 2");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
