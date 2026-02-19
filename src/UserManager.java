import java.util.ArrayList;

public class UserManager {
    private final ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }
    //----------------methods-------------------------------

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
