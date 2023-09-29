package crud_app.dao;

import crud_app.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    void addUser(User user);
    List<User> getAllUsers();
    void deleteUser(long id);
    User findUserById(long id);

    Optional<User> findUserByEmail(String email);
}

