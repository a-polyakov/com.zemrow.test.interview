package preparing.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentTask03ReentrantLock {
    public static class Counter {

        private final ReentrantLock lock = new ReentrantLock();

        private volatile int count;

        public int getCount() {
            return count;
        }

        public void increment() {
            lock.lock();
            count = count + 1;
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 1 start");
                for (int i = 0; i < 100_000; i++) {
                    counter.increment();
                }
                System.out.println("Thread 1 finish, Counter:" + counter.getCount());
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 2 start");
                for (int i = 0; i < 100_000; i++) {
                    counter.increment();
                }
                System.out.println("Thread 1 finish, Counter:" + counter.getCount());
            }
        };
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Test end, Counter:" + counter.getCount());
    }
}
