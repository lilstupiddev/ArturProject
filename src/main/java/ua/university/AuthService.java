package ua.university;

import java.util.*;

public class AuthService {

    private final Map<String, User> users = new HashMap<>();

    public AuthService() {
        users.put("admin", new User("admin", "123", Role.ADMIN));
    }

    public Optional<User> login(String login, String password) {
        User u = users.get(login);
        if (u != null && u.password.equals(password)) {
            return Optional.of(u);
        }
        return Optional.empty();
    }
}