package interview.dellin.exercise04;

/**
 * @author E.Bolgar on 31.03.2017.
 */
class Task04Plus {

    interface MAP<K, V> {
        public V get(K key);

        public void put(K key, V val);

        public V remove(K key);
    }

    /*
     * Необходимо реализовать интерфейс, который бы обеспечил нам неблокирующее чтение.<br/>
     * Т.е. к примеру мы используем его этот MAP как хранилище всех авторизованных пользователей,
     * при этом пользователь логинится с утра и выходит вечером, а при каждом обращении к серверу
     * мы выполняем get для проверки.
     */

    class Users<K, V> implements MAP<K, V> {
        @Override
        public V get(K key) {
            //TODO
            throw new UnsupportedOperationException();
        }

        @Override
        public void put(K key, V val) {
            //TODO
            throw new UnsupportedOperationException();
        }

        @Override
        public V remove(K key) {
            //TODO
            throw new UnsupportedOperationException();
        }
    }
}
