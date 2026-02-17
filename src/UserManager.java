import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
    User user;
    Scanner scanner = new Scanner(System.in);
    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    //----------------methods-------------------------------
    public void getInfo(){
        System.out.print("Id: ");
        user.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Name: ");
        user.setName(scanner.nextLine());
        System.out.print("Email: ");
        user.setEmail(scanner.nextLine());
    }

    public void addUser(User user){
        users.add(user);
        System.out.println("User added successfully");
    }

    public void showUser(int id){
        System.out.print("Result: ");
        System.out.println(users.get(id));
    }

    public void updateUser(User user) {
        users.set(user.getId(), user);
        System.out.println("User updated successfully");
    }

    public void deleteUser(int id) {
        users.remove(user.getId());
        System.out.println("User removed successfully");
    }
}
