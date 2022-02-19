package interview.dellin.exercise08;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author E.Bolgar on 05.06.2017.
 */
@Service
public class UserServiceBean implements UserService {
    @Override
    public User getUser(String login) {
        return getUser(getUserId(login));
    }

    @Cacheable
    public Long getUserId(String login) {
        //some implementation
        return 1L;
    }

    @Cacheable
    public User getUser(Long id) {
        //some implementation
        return new User();
    }
}
