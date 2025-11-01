package interview.dellin.exercise09;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @author E.Bolgar on 05.06.2017.
 */
@Service
public class UserServiceBean implements UserService {
    @PersistenceContext
    private EntityManager em;

    @Override
    public User create(String login) {
        User user = new User();
        user.setLogin(login);
        return persist(user);
    }

    @Transactional
    public User persist(User user) {
        em.persist(user);
        return user;
    }
}
