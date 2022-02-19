package interview.dellin.exercise01;

import java.util.*;

/**
 * @author E.Bolgar on 15.03.2017.
 */
class Task01 {

    /**
     * Выборка уникальных людей по параметрам, а не по идентификатору
     *
     * @param source исходная коллекция
     * @return коллекция уникальных
     */
    public static Collection<Person> getUniques(Collection<Person> source) {
        // TODO
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        Collection<Person> list = new ArrayList<Person>();
        final Date birth = new Date();
        for (int i = 0; i < 10000000; i++) {
            final Person person = new Person();
            person.setId((long) i);
            if (i % 10 != 0) {
                person.setFamily("family" + i);
            }
            person.setName("name");
            if (i % 3 != 0) {
                person.setBirth(birth);
            }
            list.add(person);
            if (i % 2 == 0) {
                list.add(person);
            }
        }
        Collections.shuffle((List<?>) list);

//        for (Person person : list) {
//            System.out.println(person);
//        }
        System.out.println("Итого записей " + list.size());
        long time = System.currentTimeMillis();
        list = getUniques(list);
        time = System.currentTimeMillis() - time;
        System.out.println("time " + time);
        System.out.println("Убираем дубли " + list.size());
//        for (Person person : list) {
//            System.out.println(person);
//        }
    }

}
