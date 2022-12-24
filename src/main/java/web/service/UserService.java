package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void add(User user);

    User get(Long id);

    void update(User user, Long id);

    void delete(Long id);

}