import java.util.Scanner;

public class GetInfo {
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
