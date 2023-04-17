package web.Repository;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepImpl implements UserRep {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public User readUser(long id) {
        return entityManager.find(User.class, id);
    }
      @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
    @Override
    public void deleteUser(long id) {
        User userNow = entityManager.find(User.class, id);
        entityManager.remove(userNow);
        System.out.println("Удаление прошло успешно");;
    }
}
