import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }
    //----------------methods-------------------------------
    public User getInfo(){
        System.out.print("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new User(id, name, email);
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
