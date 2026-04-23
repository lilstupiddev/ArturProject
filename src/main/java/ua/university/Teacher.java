package ua.university;

public final class Teacher extends Person {
    String position;

    public Teacher(String id, String name, String email, String position) {
        super(id, name, email);
        this.position = position;
    }
}