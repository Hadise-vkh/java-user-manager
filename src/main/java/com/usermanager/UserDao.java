package com.usermanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
