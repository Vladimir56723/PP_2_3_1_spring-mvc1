package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private  EntityManager entityManager;

  /*  public UserDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }*/

    public void add(User user) {
        entityManager.persist(user);

    }


    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("FROM User", User.class).getResultList();

    }
    @Override
    public User get(Long id) {
        return entityManager.find(User.class, id);
    }


        @Override
        public void update(User user, Long id) {
            User user1 = entityManager.find(User.class, id);
            user1.setFirstname(user.getFirstname());
            user1.setLastname(user.getLastname());
            user1.setEmail(user.getEmail());
            entityManager.merge(user1);
    }
    @Override
    public void delete(Long id) {
        entityManager.remove(get(id));
    }
}
