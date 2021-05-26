package by.project.spring.calculate.dao;

import by.project.spring.calculate.model.entity.user.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();
    void save(User user);
    User getById(int id);
    User getByUsername(String username);
    User getByLogin(String login);
    boolean contains(String login);

}
