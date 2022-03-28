package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        UserService us = new UserServiceImpl();
        List<User> users = new ArrayList<>();
        users.add(new User("Kek", "Kekovich", (byte) 1));
        users.add(new User("Keke", "Kekovic", (byte) 2));
        users.add(new User("Kekek", "Kekovi", (byte) 3));
        users.add(new User("Kekeke", "Kekov", (byte) 4));

        Consumer<User> saveUserAndSout = (x) -> {
            us.saveUser(x.getName(), x.getLastName(), x.getAge());
            System.out.println("User с именем – " + x.getName() + " добавлен в базу данных");
        };

        us.createUsersTable();
        for (User user : users) {
            saveUserAndSout.accept(user);
        }
        us.getAllUsers();
        us.cleanUsersTable();
        us.dropUsersTable();

    }
}
