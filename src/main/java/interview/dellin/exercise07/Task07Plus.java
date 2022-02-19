package interview.dellin.exercise07;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author E.Bolgar on 19.05.2017.
 */
class Task07Plus {

    public Map<Record, IdentityGroup> getIdentityGroups(Collection<Record> records) {
        //TODO необходимо для каждой входящей записи из records построить полные группы идентичности
        throw new UnsupportedOperationException();
    }


    public Map<Record, IdentityGroup> getIdentityGroups(Collection<Record> records, IdentityContext context) {
        //TODO необходимо для каждой входящей записи из records построить полные группы идентичности
        throw new UnsupportedOperationException();
    }

    /**
     * Получить все известные связи типа Identity для всех указанных records
     */
    private Collection<Identity> getIdentities(Collection<Record> records) {
        //Предполагаем, что данный метод реализован
        return null;
    }

    /**
     * Получить все известные связи типа Identity для всех указанных records
     */
    private Collection<Identity> getIdentities(Record... records) {
        //Предполагаем, что данный метод реализован
        return null;
    }

    /**
     * Группа одинаковых записей.
     * В группу включаются все записи по транзитивному признаку.
     * Т.е. если есть связи Identity A - B и B - C, то группа содержит все три сущности
     */
    static class IdentityGroup extends HashSet<Identity> {
        public Set<Record> getRecords() {
            Set<Record> set = new HashSet<>();
            for (Identity identity : this) {
                set.add(identity.getRecord());
                set.add(identity.getReference());
            }
            return set;
        }
    }

    static interface IdentityContext {
        /**
         * Текущий пользователь
         */
        public String getUser();

        /**
         * true - если в обработку включаются все временные записи данного пользователя, если false см getTemporaryIncludedSet
         */
        public boolean isIncludedAllUserRecords();

        /**
         * Список Identity, которые следует включить в обработку
         */
        public Set<BigInteger> getTemporaryIncludedSet();

        /**
         * Список Identity, которые следует исключить из обработки.
         * Этот список имеет наивысший приоритет
         */
        public Set<BigInteger> getExcludeSet();
    }
}
