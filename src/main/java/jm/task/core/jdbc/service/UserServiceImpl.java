package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        UserDaoJDBCImpl kek = new UserDaoJDBCImpl();
        kek.createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoJDBCImpl kek = new UserDaoJDBCImpl();
        kek.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UserDaoJDBCImpl kek = new UserDaoJDBCImpl();
        kek.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        UserDaoJDBCImpl kek = new UserDaoJDBCImpl();
        kek.removeUserById(id);
    }

    public List<User> getAllUsers() {
        UserDaoJDBCImpl kek = new UserDaoJDBCImpl();
        return kek.getAllUsers();
    }

    public void cleanUsersTable() {
        UserDaoJDBCImpl kek = new UserDaoJDBCImpl();
        kek.cleanUsersTable();
    }
}
