import java.util.InputMismatchException;
import java.util.Scanner;

public class GetInfo {
    public static User getInfo(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print("Id: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Name: ");
                String name = scanner.nextLine().trim();

                System.out.print("Email: ");
                String email = scanner.nextLine().trim();

                if (email.contains("@") && email.contains("." )&& !name.isBlank())
                    return new User(id, name, email);
                else
                    System.out.println("Invalid input, try again");

            }catch (InputMismatchException e){
                System.out.println("Please enter valid inputs");
                scanner.nextLine();
            }
        }
    }
}
