
public class User {
    UserManager userManager;

    @Override
    public String toString() {
        return "User {" +
                " id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}' + "\n";
    }

//------------fields-------------------------------
    private int id;
    private String name;
    private String email;

//------------getter & setter----------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//----------------constructors-------------------------

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public User() {
    }

}
