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
        UserDaoJDBCImpl ud = new UserDaoJDBCImpl();
        ud.createUsersTable();
        ud.saveUser("Kek", "Kekovich", (byte) 1);
        ud.saveUser("Keke", "Kekovic", (byte) 2);
        ud.saveUser("Kekek", "Kekovi", (byte) 3);
        ud.saveUser("Kekeke", "Kekov", (byte) 4);
        ud.getAllUsers();
        ud.cleanUsersTable();
        ud.dropUsersTable();

    }
}
