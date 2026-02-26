package com.usermanager;

import java.util.ArrayList;
import java.util.Scanner;

public class UserController {
    Scanner scanner = new Scanner(System.in);
    UserDao userDao = new UserDao();

    public void start() {
        boolean change;
        while (true) {
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
                if (firstInput.trim().isBlank()) {
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
                            change = userDao.addUser(user);
                            if (change) {
                                System.out.println("User added successfully\n");
                            } else
                                System.out.println("User with this email already exist, try again\n");
                            break;
                        case 2:
                            ArrayList<User> userList = userDao.getAll();
                            if (userList == null || userList.isEmpty()) {
                                System.out.println("No users found\n");
                                break;
                            }
                            for (User usr : userList) {
                                System.out.println(usr);
                            }
                            break;
                        case 3:
                            id = getJustId();
                            user = userDao.getById(id);
                            if (user != null) {
                                System.out.println(user);
                            } else
                                System.out.println("user not exist\n");
                            break;
                        case 4:
                            user = getAllInfo();
                            change = userDao.updateUser(user);
                            if (change) {
                                System.out.println("User updated successfully\n");
                            } else
                                System.out.println("User not exist, check users id by option 2\n");
                            break;
                        case 5:
                            id = getJustId();
                            System.out.print("Are you sure? (Y/N): ");
                            String answer = scanner.nextLine();
                            if (answer.equalsIgnoreCase("y")) {
                                change = userDao.deleteUser(id);
                                if (change) {
                                    System.out.println("User deleted successfully\n");
                                } else
                                    System.out.println("User not exist, check users id by option 2\n");
                            } else if (answer.equalsIgnoreCase("n")) {
                                break;
                            } else
                                System.out.println("Not valid, try again\n");
                            break;
                    }
                }
            } catch (NumberFormatException e) {
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
            if (!email.contains("@") || !email.contains("."))
                System.out.println("Invalid Email, try again");
            else
                return new User(name, email);
        }
    }

    public int getJustId() {
        int id;
        while (true) {
            System.out.print("User Id: ");
            String input = scanner.nextLine();
            if (input.trim().isBlank()) {
                System.out.println("ID can't be empty! try again");
                continue;
            }
            try {
                id = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer number for ID");
                continue;
            }
            return id;
        }
    }
}
