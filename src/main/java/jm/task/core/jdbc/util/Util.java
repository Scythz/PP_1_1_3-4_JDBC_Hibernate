package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    final private String userName = "root";
    final private String password = "ErT645QwE";
    final private String connectionUrl = "jdbc:mysql://localhost:3306/kata";


    public Connection connect() {
        Connection connection = null;
        try {
            // реализуйте настройку соеденения с БД
            connection = DriverManager.getConnection(connectionUrl, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
