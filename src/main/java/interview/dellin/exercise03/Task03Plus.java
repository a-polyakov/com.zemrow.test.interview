package interview.dellin.exercise03;

/**
 * @author E.Bolgar on 15.03.2017.
 */
class Task03Plus {

    /**
     * Некоторые задачи являются более приоритетными,
     * и они не должны ждать выполнения менее приоритетных
     */
    static class Executor {
        /**
         * Добавить задачу для выполнения
         * (при этом одна задача может быть добавлена несколько раз - так мы можем повысить приоритет)
         *
         * @param task     задача для выполнения
         * @param priority если true, то задача выполняет в приоритетном режиме
         */
        public void offer(Runnable task, boolean priority) {
            //TODO
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
}
