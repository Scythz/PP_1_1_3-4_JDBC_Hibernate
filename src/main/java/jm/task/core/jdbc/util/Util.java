package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    final private static String userName = "root";
    final private static String password = "ert645qw";
    final private static String connectionUrl = "jdbc:mysql://localhost:3306/kata";
    final private static String driver = "com.mysql.cj.jdbc.Driver";
    final private static SessionFactory FACTORY = FactoryHolder.FACTORY;

    public static class UtilHolder{
        public static final Util UTIL_INSTANCE = new Util();
    }
    public static Util getInstance() {
        return UtilHolder.UTIL_INSTANCE;
    }

    private Util() {
    }

    private static class FactoryHolder {
        private static SessionFactory sessionFactory;

        public static final SessionFactory FACTORY = initialize();

        private static SessionFactory initialize() {
            if (sessionFactory == null) {
                try {
                    Configuration configuration = new Configuration();

                    Properties settings = new Properties();
                    settings.put(Environment.DRIVER, driver);
                    settings.put(Environment.URL, connectionUrl);
                    settings.put(Environment.USER, userName);
                    settings.put(Environment.PASS, password);
                    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

                    configuration.setProperties(settings);
                    configuration.addAnnotatedClass(User.class);

                    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

                    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return sessionFactory;
        }
    }


    public static SessionFactory getFactory() {
        return FACTORY;
    }




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
