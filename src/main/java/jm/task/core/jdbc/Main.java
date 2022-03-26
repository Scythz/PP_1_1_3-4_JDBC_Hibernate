package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        UserService us = new UserServiceImpl();
        us.createUsersTable();
        us.saveUser("Kek", "Kekovich", (byte) 1);
        us.saveUser("Keke", "Kekovic", (byte) 2);
        us.saveUser("Kekek", "Kekovi", (byte) 3);
        us.saveUser("Kekeke", "Kekov", (byte) 4);
        us.getAllUsers();
        us.cleanUsersTable();
        us.dropUsersTable();

    }
}
