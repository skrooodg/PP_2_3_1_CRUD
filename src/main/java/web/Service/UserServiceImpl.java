package web.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.Repository.UserRep;
import web.models.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final UserRep userRepS;

    public UserServiceImpl(UserRep userRepS) {
        this.userRepS = userRepS;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepS.getAllUsers();
    }

    @Override
    public void createUser(User user) {
    userRepS.createUser(user);
    }

    @Override
    public void updateUser(User user) {
    userRepS.updateUser(user);
    }

    @Override
    public User readUser(long id) {
        return userRepS.readUser(id);
    }

    @Override
    public void deleteUser(long id) {
        userRepS.deleteUser(id);
    }
}
