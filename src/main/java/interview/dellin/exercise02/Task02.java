package interview.dellin.exercise02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author E.Bolgar on 15.03.2017.
 */
class Task02 {

    /**
     * вернуть имена разработчиков, каждый из которых знает все языки из коллекции
     *
     * @param statement
     * @param languages
     * @return
     */
    public static Collection<String> getDevelopers(final Statement statement, Collection<String> languages) {
        //TODO
        throw new UnsupportedOperationException();
    }

    public static void main(String args[]) throws Exception {
        Class.forName("org.h2.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "sa")) {
            try (final Statement statement = connection.createStatement()) {
                statement.execute("CREATE table developer (" +
                        " id INT PRIMARY KEY," +
                        " name VARCHAR (100) NOT NULL" +
                        ")");

                statement.execute("CREATE table language (" +
                        " id INT PRIMARY KEY," +
                        " name VARCHAR (100) NOT NULL" +
                        ")");

                statement.execute("CREATE table experience (" +
                        " dev_id INT NOT NULL REFERENCES developer(id)," +
                        " lang_id INT NOT NULL REFERENCES language(id)," +
                        " PRIMARY KEY (dev_id, lang_id)" +
                        ")");

                statement.executeUpdate("INSERT INTO developer VALUES " +
                        "(1, 'Вася'), " +
                        "(2, 'Петя'), " +
                        "(3, 'Иван') "
                );

                statement.executeUpdate("INSERT INTO language VALUES " +
                        "(1, 'Java'), " +
                        "(2, 'C++'), " +
                        "(3, 'Delphi') "
                );

                statement.executeUpdate("INSERT INTO experience VALUES " +
                        "(1, 1), " +
                        "(1, 2), " +
                        "(2, 1), " +
                        "(2, 3), " +
                        "(3, 1), " +
                        "(3, 2), " +
                        "(3, 3) "
                );

                System.out.println("Содержимое БД");
                final ResultSet resultSet = statement.executeQuery("select d.name, l.name from" +
                        " developer d" +
                        " join experience e on e.dev_id=d.id" +
                        " join language l on l.id=e.lang_id");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
                }
                System.out.println("Все разработчики");
                System.out.println(getDevelopers(statement, null));
                System.out.println("Все разработчики");
                System.out.println(getDevelopers(statement, Collections.emptyList()));
                System.out.println("Разработчики, которые знают одновременно и Java и Delphi");
                System.out.println(getDevelopers(statement, Arrays.asList("Java", "Delphi")));
                System.out.println("Разработчики, которые знают одновременно и Java и C++ и Delphi");
                System.out.println(getDevelopers(statement, Arrays.asList("Java", "C++", "Delphi")));
            }
        }
    }

}
