package web.Service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(User user);
    User readUser(long id);
    void deleteUser(long id);
}
