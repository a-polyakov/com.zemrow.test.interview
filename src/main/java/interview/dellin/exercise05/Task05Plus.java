package interview.dellin.exercise05;

import javax.ejb.Init;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author E.Bolgar on 31.03.2017.
 */
class Task05Plus {
    /*
     *  EJB.
     *  Нам необходимо реализовать хранение в памяти списка всех пользователей,
     *  при этом мы зачитываем их при инициализации приложения.
     */
    class User implements Serializable {
        //какой-то бин
    }

    interface UserStorage {
        User get(String login);
    }

    /**
     * У нас есть такая реализация.
     * Чем она плоха, как ее исправить.
     */
    @Stateless
    static class UserStorageBean implements UserStorage {
        private static final Map<String, User> map = new HashMap<>();

        @Init
        public void initialize() {
            //какое-то чтение данных и заполнение map
        }

        @Override
        public User get(String login) {
            return map.get(login);
        }
    }

}
