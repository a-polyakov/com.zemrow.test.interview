package interview.dellin.exercise03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author E.Bolgar on 15.03.2017.
 */
class Task03 {

    /*
     Есть некоторый набор задач (Runnable), которые "постоянно" должны мониторить некоторый ресурс
     и в случае необходимости выполнять какие-то длительные операции.
     Но количество задач может превышать количество разрешенных потоков.


     Соответственно необходимо реализовать класс Executor,
     который будет выполнять задачи по кругу.
     */

    static class Executor {
        /**
         * Конструктор
         *
         * @param threads количество потоков, для выполнения задач
         */
        public Executor(int threads) {
            //TODO
        }

        /**
         * Добавить задачу для выполнения
         * (при этом одна задача может быть добавлена несколько раз - так мы можем повысить приоритет)
         *
         * @param task задача для выполнения
         */
        public void offer(Runnable task) {
            //TODO
            task.run();
        }

        /**
         * Удалить задачу
         * (если задача добавлена несколько раз, то нужно удалить только один экземпляр)
         *
         * @param task задача для удаление
         * @return true - если задача удалена, false - если такой задачи нет
         */
        public boolean remove(Runnable task) {
            //TODO
            return false;
        }
    }

    public static void main(String[] args) {
        final Executor executor = new Executor(4);
        for (int i = 0; i < 20; i++) {
            final ExampleTask task = new ExampleTask(i);
            if (i % 2 == 0) {
                executor.offer(task);
            }
            executor.offer(task);
        }

    }

    static class ExampleTask implements Runnable {
        private final int index;
        private final AtomicInteger count;

        public ExampleTask(int index) {
            this.index = index;
            count = new AtomicInteger();
        }

        @Override
        public void run() {
            System.out.println("Run " + index + " " + count.incrementAndGet());
            try {
                Thread.sleep(2000);
            } catch (Exception ignore) {

            }
        }
    }
}
