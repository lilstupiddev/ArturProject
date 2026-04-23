package ua.university;


public class User {
    String login;
    String password;
    Role role;

    public User(String l, String p, Role r) {
        login = l;
        password = p;
        role = r;
    }
}