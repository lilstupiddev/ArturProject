package ua.university;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    private final Repository<Student> repo;

    public StudentService(Repository<Student> repo) {
        this.repo = repo;
    }

    public List<Student> findByCourse(int course) {
        return repo.findAll().stream()
                .filter(s -> s.course == course)
                .sorted(Comparator.comparing(s -> s.name))
                .collect(Collectors.toList());
    }
}
