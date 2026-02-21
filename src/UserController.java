import java.util.InputMismatchException;
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
                int choice = scanner.nextInt();
                User user = new User();
                if (choice < 0 || choice > 4) {
                    System.out.println("Please enter a number from 0 to 4");
                    continue;
                }
                if (choice == 0) {
                    break;
                } else {
                    switch (choice) {
                        case 1:
                            user = GetInfo.getInfo();
                            userManager.addUser(user);
                            break;
                        case 2:
                            System.out.print("Id: ");
                            user.setId(scanner.nextInt());
                            userManager.showUser(user);
                            break;
                        case 3:
                            user = GetInfo.getInfo();
                            userManager.updateUser(user);
                            break;
                        case 4:
                            System.out.print("Id: ");
                            user.setId(scanner.nextInt());
                            userManager.deleteUser(user);
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number(0 to 4) ");
                scanner.nextLine();
            }
        }
    }
}
