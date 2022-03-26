package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl kek = new UserDaoJDBCImpl();

    public void createUsersTable() {
        kek.createUsersTable();
    }

    public void dropUsersTable() {
        kek.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        kek.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        kek.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return kek.getAllUsers();
    }

    public void cleanUsersTable() {
        kek.cleanUsersTable();
    }
}
