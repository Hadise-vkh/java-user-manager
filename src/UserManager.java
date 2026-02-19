import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserManager {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }
    //----------------methods-------------------------------

    public User getInfo(){
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

    public void addUser(User user){
        users.add(user);
        System.out.println("User added successfully");
    }

    public void showUser(int id){
        System.out.print("Result: ");
        System.out.println(users.get(id).toString()
        );
    }

    public void updateUser(User user) {
        users.set(user.getId(), user);
        System.out.println("User updated successfully");
    }

    public void deleteUser(int id) {
        users.remove(id);
        System.out.println("User removed successfully");
    }
}
