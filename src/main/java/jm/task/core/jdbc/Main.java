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

        List<User> newUsers = new ArrayList<>();
        newUsers.add(new User("Kek", "Kekovich", (byte) 1));
        newUsers.add(new User("Keke", "Kekovic", (byte) 2));
        newUsers.add(new User("Kekek", "Kekovi", (byte) 3));
        newUsers.add(new User("Kekeke", "Kekov", (byte) 4));

        Consumer<User> saveUserAndSout = (x) -> {
            us.saveUser(x.getName(), x.getLastName(), x.getAge());
            System.out.println("User с именем – " + x.getName() + " добавлен в базу данных");
        };

        us.createUsersTable();
        newUsers.forEach(saveUserAndSout);
        List<User> users = us.getAllUsers();
        users.forEach(System.out::println);
        us.cleanUsersTable();
        us.dropUsersTable();

    }
}
