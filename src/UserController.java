import java.util.Scanner;

public class UserController {
    public void start(){
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("""
                What do you want to do?
                Choose a number(enter 0 to exit):
                1.Add User
                2.Show User
                3.Update User
                4.Delete User
                Your choice:\s""");
            try {
                String firstInput = scanner.nextLine();
                if (firstInput.trim().isBlank()){
                    System.out.println("Please enter a number from 0 to 4\n");
                    continue;
                }
                int choice = Integer.parseInt(firstInput);
                User user;
                if (choice < 0 || choice > 4) {
                    System.out.println("Please enter a number from 0 to 4");
                    continue;
                }
                if (choice == 0) {
                    break;
                } else {
                    switch (choice) {
                        case 1:
                            user = getInfo();
                            userManager.addUser(user);
                            break;
                        case 2:
                            user = getJustId();
                            userManager.showUser(user);
                            break;
                        case 3:
                            user = getInfo();
                            userManager.updateUser(user);
                            break;
                        case 4:
                            user = getJustId();
                            userManager.deleteUser(user);
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number(0 to 4) ");
            }
        }
    }
    public static User getInfo() {
        Scanner scanner = new Scanner(System.in);
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
                System.out.println("Please enter integer number for ID\n");
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
            if (!email.contains("@") && !email.contains("."))
                System.out.println("Invalid Email, try again");
            else
                return new User(id, name, email);
        }
    }

    public static User getJustId() {
        Scanner scanner = new Scanner(System.in);
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
                System.out.println("Please enter integer number for ID\n");
                continue;
            }
            return new User(id);
        }
    }
}
