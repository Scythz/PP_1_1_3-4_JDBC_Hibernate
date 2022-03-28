package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        UserService us = new UserServiceImpl();
        User user1 = new User("Kek", "Kekovich", (byte) 1);
        User user2 = new User("Keke", "Kekovic", (byte) 2);
        User user3 = new User("Kekek", "Kekovi", (byte) 3);
        User user4 = new User("Kekeke", "Kekov", (byte) 4);

        Consumer<User> saveUserAndSout = (x) -> {
            us.saveUser(x.getName(), x.getLastName(), x.getAge());
            System.out.println("User с именем – " + x.getName() + " добавлен в базу данных");
        };


        us.createUsersTable();
        saveUserAndSout.accept(user1);
        saveUserAndSout.accept(user2);
        saveUserAndSout.accept(user3);
        saveUserAndSout.accept(user4);
        List<User> list = us.getAllUsers();
        us.cleanUsersTable();
        us.dropUsersTable();

    }
}
