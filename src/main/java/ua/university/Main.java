package ua.university;

import java.net.ServerSocket;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        Repository<Student> repo = new Repository<>();
        StudentService service = new StudentService(repo);
        AuthService auth = new AuthService();

        // автозбереження
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (Exception ignored) {}
            }
        }).start();

        // TCP
        new Thread(() -> {
            try {
                new ServerSocket(1234).accept();
            } catch (Exception ignored) {}
        }).start();


        System.out.print("Логін: ");
        String l = sc.nextLine();
        System.out.print("Пароль: ");
        String p = sc.nextLine();

        Optional<User> user = auth.login(l, p);
        if (user.isEmpty()) {
            System.out.println("Доступ відхилено ");
            return;
        }

        // MENU
        while (true) {
            System.out.println("\n1. Додати студента");
            System.out.println("2. Відфільтрувати за курсом");
            System.out.println("3. Видалити студента");
            System.out.println("0. Вихід");

            int ch = Integer.parseInt(sc.nextLine());

            try {
                switch (ch) {
                    case 1 -> {
                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("Ім'я: ");
                        String name = sc.nextLine();

                        repo.save(id, new Student(id, name, "a@a", 1, "A"));
                    }

                    case 2 -> {
                        System.out.print("Курс: ");
                        int c = Integer.parseInt(sc.nextLine());

                        service.findByCourse(c)
                                .forEach(s -> System.out.println(s.name));
                    }

                    case 3 -> {
                        System.out.print("ID: ");
                        repo.delete(sc.nextLine());
                    }

                    case 0 -> System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Помилка");
            }
        }
    }
}