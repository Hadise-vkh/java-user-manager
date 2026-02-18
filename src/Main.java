import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(userManager.getUsers().toString());
            System.out.print("What do you want to do?\nChoose a number(enter 0 to exit):\n" +
                    "1.Add User\n2.Show User\n3.Update User\n4.Delete User\nYour choice: ");
            int choice = scanner.nextInt();
            User user = new User();
            if (choice == 0){
                break;
            }else {
                switch (choice){
                    case 1:
                        user = userManager.getInfo();
                        userManager.addUser(user);
                        break;
                    case 2:
                        System.out.print("Id: ");
                        user.setId(scanner.nextInt());
                        userManager.showUser(user.getId());
                        break;
                    case 3:
                        user = userManager.getInfo();
                        userManager.updateUser(user);
                        break;
                    case 4:
                        System.out.print("Id: ");
                        user.setId(scanner.nextInt());
                        userManager.deleteUser(user.getId());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + choice);
                }
            }
        }
    }
}