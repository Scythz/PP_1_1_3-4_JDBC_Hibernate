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

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Kek", "Kekovich", (byte) 1);
        User user2 = new User("Keke", "Kekovic", (byte) 2);
        User user3 = new User("Kekek", "Kekovi", (byte) 3);
        User user4 = new User("Kekeke", "Kekov", (byte) 4);


        UserService us = new UserServiceImpl();
        us.createUsersTable();
        us.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        System.out.println("User с именем – " + user1.getName() + " добавлен в базу данных");
        us.saveUser(user1.getName(), user2.getLastName(), user2.getAge());
        System.out.println("User с именем – " + user2.getName() + " добавлен в базу данных");
        us.saveUser(user1.getName(), user3.getLastName(), user3.getAge());
        System.out.println("User с именем – " + user3.getName() + " добавлен в базу данных");
        us.saveUser(user1.getName(), user4.getLastName(), user4.getAge());
        System.out.println("User с именем – " + user4.getName() + " добавлен в базу данных");
        List<User> list = us.getAllUsers();
        us.cleanUsersTable();
        us.dropUsersTable();

    }
}
