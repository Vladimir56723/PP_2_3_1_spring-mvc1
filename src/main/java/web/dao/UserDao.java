package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void add(User user);

    User get(Long id);

    void update(User user, Long id);

    void delete(Long id);


}
