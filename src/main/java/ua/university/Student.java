package ua.university;

public final class Student extends Person {
    int course;
    String group;

    public Student(String id, String name, String email, int course, String group) {
        super(id, name, email);
        this.course = course;
        this.group = group;
    }

    public int getCourse() {
        return course;
    }
}