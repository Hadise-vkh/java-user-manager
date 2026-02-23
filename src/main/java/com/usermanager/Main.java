package com.usermanager;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.start();
//        try(Connection connection = DatabaseConnection.getConnection()){
//            System.out.println("connected");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}