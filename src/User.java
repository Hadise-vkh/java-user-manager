
public class User {

    @Override
    public String toString() {
        return "User {" +
                " id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}' + "\n";
    }

//------------fields-------------------------------

    private final int id;
    private String name;
    private String email;

//------------getter----------------------------------

    public int getId() {
        return id;
    }

//----------------constructors-------------------------

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(int id) {
        this.id = id;
    }
}
