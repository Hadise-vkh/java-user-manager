package com.usermanager;

public class User {

    @Override
    public String toString() {
        return "id = " + id + "\n" +
                "name = " + name + "\n" +
                "email = " + email + "\n";
    }

    //fields
    private int id;
    private String name;
    private String email;

    //getters
    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }

    //constructors
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public User(String name, String email){
        this.name = name;
        this.email = email;
    }
}
