package com.usermanager;
import java.util.Scanner;

public class UserController {
    Scanner scanner = new Scanner(System.in);
    public void start(){
        UserDao userDao = new UserDao();
        while(true) {
            System.out.print("""
                What do you want to do?
                Choose a number(enter 0 to exit):
                1.Add User
                2.Show all users
                3.show user by id
                4.Update User
                5.Delete User
                Your choice:\s""");
            try {
                String firstInput = scanner.nextLine();
                if (firstInput.trim().isBlank()){
                    System.out.println();
                    System.out.println("Please enter a number from 0 to 5");
                    continue;
                }
                int choice = Integer.parseInt(firstInput);
                User user;
                int id;
                if (choice < 0 || choice > 5) {
                    System.out.println("\nPlease enter a number from 0 to 5");
                    continue;
                }
                if (choice == 0) {
                    break;
                } else {
                    switch (choice) {
                        case 1:
                            user = getInfo();
                            userDao.addUser(user);
                            break;
                        case 2:
                            userDao.getAll();
                            break;
                        case 3:
                            id = getJustId();
                            userDao.getById(id);
                            break;
                        case 4:
                            user = getAllInfo();
                            userDao.updateUser(user);
                            break;
                        case 5:
                            id = getJustId();
                            userDao.deleteUser(id);
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("\nPlease enter a valid number(0 to 5) ");
            }
        }
    }

    public User getAllInfo() {
        int id;
        while (true) {
            System.out.print("Id: ");
            String input = scanner.nextLine();
            if (input.trim().isBlank()) {
                System.out.println("ID can't be empty! try again");
                continue;
            }
            try {
                id = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter integer number for ID");
                continue;
            }

            System.out.print("Name: ");
            String name = scanner.nextLine().trim();
            if (name.isBlank()) {
                System.out.println("Name can't be empty, try again");
                continue;
            }

            System.out.print("Email: ");
            String email = scanner.nextLine().trim();
            if (email.isBlank()) {
                System.out.println("Email can't be empty, try again");
            }
            if (!email.contains("@") || !email.contains("."))
                System.out.println("Invalid Email, try again");
            else
                return new User(id, name, email);
        }
    }

    public User getInfo() {
        while (true) {

            System.out.print("Name: ");
            String name = scanner.nextLine().trim();
            if (name.isBlank()) {
                System.out.println("Name can't be empty, try again");
                continue;
            }

            System.out.print("Email: ");
            String email = scanner.nextLine().trim();
            if (email.isBlank()) {
                System.out.println("Email can't be empty, try again");
            }
            if (!email.contains("@") && !email.contains("."))
                System.out.println("Invalid Email, try again");
            else
                return new User(name, email);
        }
    }

    public int getJustId(){
        int id;
        while (true){
            System.out.print("User Id: ");
            String input = scanner.nextLine();
            if (input.trim().isBlank()){
                System.out.println("ID can't be empty! try again");
                continue;
            }
            try {
                id = Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("Please enter integer number for ID");
                continue;
            }
            return id;
        }
    }
}
