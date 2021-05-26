package by.project.spring.calculate.dao.InMemory;

import by.project.spring.calculate.dao.UserDAO;
import by.project.spring.calculate.model.entity.user.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class InMemoryUserDAO implements UserDAO {
    private static List<User> userList = new ArrayList<>();
    private static UserDAO instance;
    private static int id = 1;

    public static UserDAO getInstance(){
        if(instance == null){
            instance = new InMemoryUserDAO();
        }
        return instance;
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public void save(User user) {
        user.setId(id++);
        userList.add(user);
    }

    @Override
    public User getById(int id) {
        for(User user : userList){
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    @Override
    public User getByUsername(String username) {
        for(User user : userList){
            if(user.getUsername() == username)
                return user;
        }
        return null;
    }

    @Override
    public User getByLogin(String login) {
        for(User user : userList){
            if(user.getLogin().equals(login))
                return user;
        }
        return null;
    }


    @Override
    public boolean contains(String login) {
        for(User user : userList){
            if(user.getLogin().equals(login))
                return true;
        }
        return false;
    }
}
