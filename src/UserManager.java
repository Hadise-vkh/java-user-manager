import java.util.ArrayList;

public class UserManager {
    private final ArrayList<User> users = new ArrayList<>();

    //----------------methods-------------------------------

    public void addUser(User user) {
        boolean check = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                check = true;
                break;
            }
        }
        if (check) {
            System.out.print("Id already exist, try another one ");
        } else {
            users.add(user);
            System.out.println("User added successfully");
        }
    }

    public void showUser(User user){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getId() == user.getId()){
                System.out.print("Result: ");
                System.out.println(users.get(i).toString());
                return;
            }
        }
            System.out.println("User with this ID doesn't exist");
    }

    public void updateUser(User user) {
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getId() == user.getId()){
                users.set(i, user);
                System.out.println("User updated successfully");
                return;
            }
        }
    }

    public void deleteUser(User user) {
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getId() == user.getId()){
                users.remove(i);
                System.out.println("User removed successfully");
                return;
            }
        }
        System.out.println("User with this ID doesn't exist");
    }
}
