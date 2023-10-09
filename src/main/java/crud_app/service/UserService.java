package crud_app.service;

import crud_app.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();
    void deleteUser(long id);
    User findUserById(long id);

}
